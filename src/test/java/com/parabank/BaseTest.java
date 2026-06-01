package com.parabank;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	
	protected TestContext tContext;

	@BeforeSuite
	@Parameters("browser")
	public void setDriver(String browser) {

		if (browser.equals("chrome")) {
			
			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("autofill.profile_enabled", false);
			prefs.put("autofill.credit_card_enabled", false);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-gpu");

			options.setExperimentalOption("prefs", prefs);
			
			driver.set(new ChromeDriver(options));
			System.out.println("Browser Is : "+browser);
		}
		else if (browser.equals("firefox"))
			driver.set(new FirefoxDriver());
		else if(browser.equals("ie"))
			 driver.set(new EdgeDriver());
		
		driver.get().manage().window().maximize();
		
		tContext = new TestContext();
	}

	public WebDriver getDriver() {
		return driver.get();
	}
	
	public TestContext getTestContext() {
		return tContext;
	}

	@AfterSuite
	public void tearDown() {
		
	}

}
