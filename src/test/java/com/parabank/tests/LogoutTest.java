package com.parabank.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parabank.BaseTest;
import com.parabank.pages.LogoutPage;

public class LogoutTest extends BaseTest {
	
	LogoutPage logoutPage;
	
	@BeforeClass
	public void setupLogoutPage() {
		logoutPage = new LogoutPage(getDriver());
	}
	
	@Test(priority = 1)
	public void logoutPage() {
		logoutPage.clickLogout();
	}
	
	@Test(priority = 2)
	public void closeBroser() {
		logoutPage.driver.close();
	}

}
