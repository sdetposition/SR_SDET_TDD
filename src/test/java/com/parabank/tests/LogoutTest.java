package com.parabank.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parabank.BaseTest;
import com.parabank.pages.LogoutPage;
import com.parabank.utils.ExtentTestManager;
import com.parabank.utils.LogUtil;

public class LogoutTest extends BaseTest {
	
	LogoutPage logoutPage;
	
	@BeforeClass
	public void setupLogoutPage() {
		logoutPage = new LogoutPage(getDriver());
	}
	
	@Test(priority = 1)
	public void logoutPage() {
		logoutPage.clickLogout();
		LogUtil.info("Logout the Page");	
	//	ExtentTestManager.getTest().info("Logout the Page");
	}
	
	@Test(priority = 2)
	public void closeBroser() {
		logoutPage.driver.close();
		LogUtil.info("Close the Browser");
	//	ExtentTestManager.getTest().info("Close the Browser");
	}

}
