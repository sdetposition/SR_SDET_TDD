package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.parabank.TestContext;
import com.parabank.commons.UserInfo;
import com.parabank.utils.LogUtil;

public class RegisterPage {	
	
	UserInfo uInfo;
	TestContext tContext;
	
	public static final String register_Link__Xpath = "//a[text()='Register']";
	
	public static final String firstName_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'firstName')]";
	public static final String lastName_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'lastName')]";	
	public static final String address_Street_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'street')]";
	public static final String address_city_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'city')]";
	public static final String address_state_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'state')]";
	public static final String address_zipCode_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'zipCode')]";
	public static final String phoneNumber_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'phoneNumber')]";
	public static final String ssn_Xppath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'ssn')]";
	public static final String username_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'username')]";
	public static final String password_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'password')]";
	public static final String confirm_pwd_Xpath = "//*[@id='customerForm']/table/tbody/tr/td/input[contains(@id,'repeatedPassword')]";
	
	public static final String submit_Btn = "//input[@type='submit' and @value='Register']";	
	public static final String register_Success_Page_Xpath = "//*[@id='rightPanel']/p";	
	public static final String register_Success_WelcomeUser_Xpath = "//*[@id='rightPanel']/h1";
	
	public WebDriver driver;	
	String url = "https://parabank.parasoft.com/parabank/index.htm";
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
		clickOnRegisterBtn();	
	}
	
	public void clickOnRegisterBtn() {
		driver.findElement(By.xpath(register_Link__Xpath)).click();
	}
	
	public void enterFirstName() {
		driver.findElement(By.xpath(firstName_Xpath)).sendKeys(uInfo.getUser());
	}
	
	public void enterLastName() {
		driver.findElement(By.xpath(lastName_Xpath)).sendKeys("Test1");
	}
	
	public void enterStreetName() {
		driver.findElement(By.xpath(address_Street_Xpath)).sendKeys("47 West 13th Street");
	}
	
	public void enterCityName() {
		driver.findElement(By.xpath(address_city_Xpath)).sendKeys("New York City");
	}
	
	public void enterStateName() {
		driver.findElement(By.xpath(address_state_Xpath)).sendKeys("New York");
	}
	
	public void enterZipCode() {
		driver.findElement(By.xpath(address_zipCode_Xpath)).sendKeys("10011");
	}
	
	public void enterPhoneNum() {
		driver.findElement(By.xpath(phoneNumber_Xpath)).sendKeys("+16469805101");
	}
	
	public void enterSSN() {
		driver.findElement(By.xpath(ssn_Xppath)).sendKeys("123-45-6789");
	}
	
	public void enterUserName() {
		driver.findElement(By.xpath(username_Xpath)).sendKeys(uInfo.getUser());
		System.out.println("User : "+uInfo.getUser());
	}
	
	public void enterPassword() {
		driver.findElement(By.xpath(password_Xpath)).sendKeys(uInfo.getPwd());
		System.out.println("Password : "+uInfo.getPwd());
	}
	
	public void enterConfirmPWD() {
		driver.findElement(By.xpath(confirm_pwd_Xpath)).sendKeys(uInfo.getPwd());
	}

	public void submitBtn() {
		driver.findElement(By.xpath(submit_Btn)).click();
	}
	
	public String registrationSubmitMessage() {
		WebElement validateText = driver.findElement(By.xpath(register_Success_Page_Xpath));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return validateText.getText();
	}
	
	
	public void submitForm(UserInfo uInfo) {
		this.uInfo = uInfo;
		LogUtil.info("Started LoginPage - submitForm");
		
		enterFirstName();
		enterLastName();
		enterStreetName();
		enterCityName();
		enterStateName();
		enterZipCode();
		enterPhoneNum();
		enterSSN();
		
		enterUserName();
		enterPassword();
		enterConfirmPWD();
		submitBtn();
		LogUtil.info("Ended LoginPage - submitForm");
	}
}
