package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage {
	
	public WebDriver driver;
	
	String accOverviewLink_Xpath = "//*[text()='Accounts Overview']";
	String accNum_Link_Xpath = "//*[@id='accountTable']/tbody/tr[1]/td[1]/a";
	String accBalance_Xpath = "//*[@id='accountTable']/tbody/tr[2]/td[2]/b";
	String accOverSection_Xpath = "(//*[normalize-space(text())='Accounts Overview'])[2]";
	
	private By overView_navigation = By.xpath(accOverviewLink_Xpath);
	private By accNum = By.xpath(accNum_Link_Xpath);
	private By accbal = By.xpath(accBalance_Xpath);
	private By accOverSection = By.xpath("(//*[normalize-space(text())='Accounts Overview'])[2]");
	
	public AccountsOverviewPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickOnOverViewLink() {
		driver.findElement(overView_navigation).click();
	}
	
	public String verifyAccountsSection() {
		return driver.findElement(accOverSection).getText();
	}
	
	public String getAccNumber() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver.findElement(accNum).getText();
	}
	
	public String getAccBalance() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver.findElement(accbal).getText();
	}

}
