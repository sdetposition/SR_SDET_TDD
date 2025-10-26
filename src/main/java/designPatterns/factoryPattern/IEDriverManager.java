package designPatterns.factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager implements DriverManager{

	@Override
	public WebDriver getDriver() {
		return new  InternetExplorerDriver();
	}

}
