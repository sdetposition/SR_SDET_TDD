package designPatterns.factoryPattern;

import org.openqa.selenium.WebDriver;

public interface DriverManager {
	public abstract WebDriver getDriver();
}
