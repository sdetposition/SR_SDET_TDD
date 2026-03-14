package com.parabank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	

	@BeforeSuite
	@Parameters("browser")
	public void setDriver(String browser) {

		if (browser.equals("chrome"))
			driver.set(new ChromeDriver());
		else if (browser.equals("firefox"))
			driver.set(new FirefoxDriver());
		else if(browser.equals("ie"))
			 driver.set(new EdgeDriver());
		
		driver.get().manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterSuite
	public void tearDown() {
		
	}

}
