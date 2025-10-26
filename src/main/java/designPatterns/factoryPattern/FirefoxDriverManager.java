package designPatterns.factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements DriverManager {

	@Override
	public WebDriver getDriver() {
		return new FirefoxDriver();
	}

}
