package designPatterns.factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements DriverManager {

	@Override
	public WebDriver getDriver() {
		return new ChromeDriver();
	}

}
