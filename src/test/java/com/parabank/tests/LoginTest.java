package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parabank.BaseTest;
import com.parabank.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	private LoginPage loginPage;	
	
	@BeforeClass
	public void setupLoginPage() {
		System.out.println("Web Driver : "+getDriver());
		loginPage = new LoginPage(getDriver());
	}

	@Test(priority = 1)
	public void validateUserFeild() {
		//System.out.println("Thread : "+Thread.currentThread().getName());
		boolean userFeild = loginPage.getUserFeild();
		Assert.assertEquals(userFeild, true);
	}

	@Test(priority = 2)
	public void validatePWDFeild() {
		//System.out.println("Thread : "+Thread.currentThread().getName());
		boolean pwdFeild = loginPage.getPwdFeild();
		Assert.assertEquals(pwdFeild, true);
	}

	@Test(priority = 3)
	public void validateLoginBtnFeild() {	
		//System.out.println("Thread : "+Thread.currentThread().getName());
		boolean loginBtn = loginPage.getLoginBtnFeild();
		Assert.assertEquals(loginBtn, true);
	}
	
	@Test(priority = 4)
	public void loginUser() {
	//	System.out.println("Thread : "+Thread.currentThread().getName());
		loginPage.loginUser("cnr", "Test@111");
	}
	
	@AfterClass
	public void tearTown() {
		//tearDown();
	}

}
