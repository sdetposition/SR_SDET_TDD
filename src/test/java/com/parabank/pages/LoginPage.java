package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	String user_Feild_name = "username";
	String pwd_Feild_name = "password";
	String login_btn_xpath = "//*[@type='submit' and @value='Log In']";
	
	String url = "https://parabank.parasoft.com/parabank/index.htm";
	
	private By userFeild = By.name(user_Feild_name);
	private By pwd_Feild = By.name(pwd_Feild_name);
	private By login_Btn = By.xpath(login_btn_xpath);
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}
	
	public boolean getUserFeild() {
		return driver.findElement(userFeild).isDisplayed();
	}
	
	public boolean getPwdFeild() {
		return driver.findElement(pwd_Feild).isDisplayed();
	}
	
	public boolean getLoginBtnFeild() {
		return driver.findElement(login_Btn).isDisplayed();
	}
	
	public void enterUser_In_UserFeild(String userInfo) {
		driver.findElement(userFeild).sendKeys(userInfo);
	}
	
	public void enterPwd_In_PwdFeild(String pwdInfo) {
		driver.findElement(pwd_Feild).sendKeys(pwdInfo);
	}
	
	public void clickOn_LoginBtn() {
		driver.findElement(login_Btn).click();
	}
	
	public void loginUser(String user, String pwd) {
		enterUser_In_UserFeild(user);
		enterPwd_In_PwdFeild(pwd);
		clickOn_LoginBtn();
	}

}
