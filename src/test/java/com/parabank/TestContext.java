package com.parabank;

import org.openqa.selenium.WebDriver;

import com.parabank.commons.UserInfo;

public class TestContext {
	
	private static TestContext context;
	private UserInfo userInfo;
	
	UserInfo uInfo;
	WebDriver driver;
	
	public TestContext() {}
	
	public static TestContext getTestContext() {
		
		if(context == null) 
			context = new TestContext();
		
		return context;
	}

	public UserInfo getUserInfo() {
		return uInfo;
	}

	public void setUserInfo(UserInfo uInfo) {
		this.uInfo = uInfo;
	}

}
