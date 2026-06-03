package com.parabank.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parabank.BaseTest;
import com.parabank.TestContext;
import com.parabank.commons.Commons;
import com.parabank.commons.UserInfo;
import com.parabank.pages.LogoutPage;
import com.parabank.pages.RegisterPage;
import com.parabank.utils.ExtentTestManager;
import com.parabank.utils.LogUtil;

import junit.framework.Assert;

public class RegisterTest extends BaseTest{
	
	private RegisterPage registerPage;
	private LogoutPage logoutPage;
	
	UserInfo uInfo;
	
	String validationMessage = "Your account was created successfully. You are now logged in.";
	
	@BeforeClass
	public void setUpRegisterPage() {
		LogUtil.info("RegisterTest - setUpRegisterPage");
		registerPage = new RegisterPage(getDriver());
		logoutPage = new LogoutPage(getDriver());		
		
		String user = Commons.generateRandomString(6);
		String pwd = Commons.generateRandomString(8);
		LogUtil.info("User - "+user+" : Pwd - "+pwd);
		//ExtentTestManager.getTest().info("User - "+user+" : Pwd - "+pwd);
		
		
		
		uInfo = new UserInfo(user,pwd);
		TestContext.getTestContext().setUserInfo(uInfo);
		
		System.out.println("U Info   : "+uInfo.toString());
		System.out.println("tContext : "+tContext.toString());
		
	}
	
	@Test(priority = 1)
	public void validateRegistrationSuccess() {		
		registerPage.submitForm(uInfo);
		String actualMsg = registerPage.registrationSubmitMessage();
		
		Assert.assertEquals(actualMsg, validationMessage);
	}
	
	@Test(priority = 2)
	public void logOut() {
		logoutPage.clickLogout();
	}
}
