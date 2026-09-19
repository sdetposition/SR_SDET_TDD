package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.parabank.utils.WaitsUtil;

public class LoginPage {
	
	WebDriver driver;
	WaitsUtil wait;
	
	String user_Feild_xpath = "//*[@name='username']";
	String pwd_Feild_name = "password";
	String login_btn_xpath = "//*[@type='submit' and @value='Log In']";
	
	String url = "https://parabank.parasoft.com/parabank/index.htm";
	
	private By userFeild = By.xpath(user_Feild_xpath);
	private By pwd_Feild = By.name(pwd_Feild_name);
	private By login_Btn = By.xpath(login_btn_xpath);
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
		wait = new WaitsUtil(driver);
	}
	
	public boolean getUserFeild() throws InterruptedException {
		WebElement ele = wait.waitElementPresent(userFeild);
		return ele.isDisplayed();
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		enterUser_In_UserFeild(user);
		enterPwd_In_PwdFeild(pwd);
		clickOn_LoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

}
