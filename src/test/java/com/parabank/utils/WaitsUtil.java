package com.parabank.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtil {
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitsUtil(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public WebElement waitElementPresent(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
