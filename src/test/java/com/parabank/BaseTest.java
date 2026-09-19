
package com.parabank;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.parabank.config.DriverFactory;
import com.parabank.utils.ExtentManager;
import com.parabank.utils.LogUtil;

public class BaseTest {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected TestContext tContext;

	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void setDriver(String browser) {
		ExtentManager.getExtentInstance();
		
		driver.set(DriverFactory.initDriver(browser));
		driver.get().manage().window().maximize();

		tContext = TestContext.getTestContext();
		LogUtil.info("Test Context Is - " + tContext);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		
		DriverFactory.quitDriver();
		driver.remove();
	}

}
