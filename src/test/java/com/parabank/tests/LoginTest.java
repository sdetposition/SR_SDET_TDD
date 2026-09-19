package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.BaseTest;
import com.parabank.TestContext;
import com.parabank.commons.UserInfo;
import com.parabank.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	private LoginPage loginPage;
	private UserInfo uInfo;
	
	@BeforeMethod
	public void setupLoginPage() {
		loginPage = new LoginPage(getDriver());
		
		uInfo = TestContext.getTestContext().getUserInfo();		
	}

	@Test(priority = 1)
	public void validateUserFeild() throws InterruptedException {
		//System.out.println("Thread : "+Thread.currentThread().getName());
		boolean userFeild = loginPage.getUserFeild();
		System.out.println("User Fields Resulst : "+userFeild);
		Assert.assertTrue(userFeild);
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
	public void loginUser()  {
	//	System.out.println("Thread : "+Thread.currentThread().getName());
		loginPage.loginUser( uInfo.getUser(), uInfo.getPwd());
		
	}
	
	@AfterMethod
	public void tearDown() {
		//tearDown();
	}

}
