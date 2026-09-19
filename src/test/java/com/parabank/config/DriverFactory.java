package com.parabank.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	static ThreadLocal<String> browserName = new ThreadLocal<>();

	public static WebDriver initDriver(String browser) {
		browserName.set(browser);

		try {

			if (BrowserStackConfig.get("executionMode").equalsIgnoreCase("grid")) {
				System.out.println("Execution Mode Is : Grid");
				driver.set(getGridConfig());
				System.out.println("Grid");
			} else if (BrowserStackConfig.get("executionMode").equalsIgnoreCase("browserstack")) {
				System.out.println("Execution Mode Is : Browser stack");
				driver.set(getBrowserstackConfig());
				System.out.println("Browserstack");
			}

			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} catch (Exception e) {
			throw new RuntimeException("Failed to initialize BrowserStack driver", e);
		}

		return driver.get();
	}

	public static ChromeOptions getChromeOptions() {

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless=new");
		// options.addArguments("--window-size=1920,1080");
		// options.addArguments("--disable-gpu");

		options.setExperimentalOption("prefs", prefs);
		return options;
	}

	public static FirefoxOptions getFirefoxOptions() {

		FirefoxOptions options = new FirefoxOptions();
		// options.addArguments("-headless"); // Run in headless mode
		options.addPreference("signon.rememberSignons", false); // Disable password manager
		options.addPreference("browser.formfill.enable", false); // Disable form autofill
		options.addPreference("extensions.formautofill.addresses.enabled", false); // Disable address autofill
		options.addPreference("extensions.formautofill.creditCards.enabled", false); // Disable credit card autofill
		options.addPreference("dom.webnotifications.enabled", false); // Disable notifications
		options.addPreference("geo.enabled", false); // Disable geolocation popup
		options.setAcceptInsecureCerts(true); // Accept insecure certificates (useful in test environments)
		options.addPreference("signon.autofillForms", false);

		return options;
	}

	public static WebDriver getBrowserstackConfig() throws MalformedURLException {
		String username = BrowserStackConfig.get("browserstack.username");
		String accessKey = BrowserStackConfig.get("browserstack.accesskey");

		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", browserName.get());
		capabilities.setCapability("browserVersion", BrowserStackConfig.get("browserVersion"));

		HashMap<String, Object> bstackOptions = new HashMap<>();
		bstackOptions.put("userName", username);
		bstackOptions.put("accessKey", accessKey);
		bstackOptions.put("os", BrowserStackConfig.get("os"));
		bstackOptions.put("osVersion", BrowserStackConfig.get("osVersion"));
		bstackOptions.put("projectName", BrowserStackConfig.get("projectName"));
		bstackOptions.put("buildName", BrowserStackConfig.get("buildName"));
		bstackOptions.put("sessionName", "Chrome Local Test");

		bstackOptions.put("local", "false");
		bstackOptions.put("debug", "true");
		bstackOptions.put("networkLogs", "true");
		bstackOptions.put("consoleLogs", "info");

		capabilities.setCapability("bstack:options", bstackOptions);

		if (browserName.get().equalsIgnoreCase("chrome"))
			capabilities.merge(getChromeOptions());
		else if (browserName.get().equalsIgnoreCase("firefox"))
			capabilities.merge(getFirefoxOptions());

		System.out.println("Driver Infop : ");

		driver.set(new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities));
		System.out.println("Driver Is :" + driver.get());

		return driver.get();
	}

	public static WebDriver getGridConfig() throws MalformedURLException {

		URL gridUrl = new URL("http://localhost:4444");

		if (browserName.get().equalsIgnoreCase("chrome")) {
			System.out.println("Browser : " + browserName.get());
			ChromeOptions options = getChromeOptions();
			return new RemoteWebDriver(gridUrl, options);
		} else if (browserName.get().equalsIgnoreCase("firefox")) {
			System.out.println("Browser : " + browserName.get());
			FirefoxOptions options = new FirefoxOptions();
			return new RemoteWebDriver(gridUrl, options);
		}

		throw new RuntimeException("Unsupported browser for Grid: " + browserName.get());
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().close();
			driver.get().quit();
			driver.remove();
			browserName.remove();
		}
	}
}
