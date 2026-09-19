package com.parabank;

import org.openqa.selenium.WebDriver;

import com.parabank.commons.UserInfo;

public class TestContext {
	
	private static ThreadLocal<TestContext> context =
			ThreadLocal.withInitial(TestContext::new);
	private UserInfo userInfo;
	
	UserInfo uInfo;
	WebDriver driver;
	
	public TestContext() {}
	
	public static TestContext getTestContext() {
		return context.get();
	}

	public UserInfo getUserInfo() {
		return uInfo;
	}

	public void setUserInfo(UserInfo uInfo) {
		this.uInfo = uInfo;
	}

}
