package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	public WebDriver driver;
	
	String logoutLink_Xpath = "//*[text()='Log Out']";
	
	private By clickLogout = By.xpath("//*[text()='Log Out']");

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogout() {
		driver.findElement(clickLogout).click();
	}

}
