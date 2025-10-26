package designPatterns.factoryPattern;

import org.openqa.selenium.WebDriver;

public class TestFactory {
	
	public static WebDriver driver;
	public static String URL = "https://www.google.com/";
	public static DriverType browser= DriverType.IE;

	public static void main(String[] args) throws InterruptedException {
	
		driver = DriverManagerFactory.getDriverManager(browser).getDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);		
		System.out.println("Google Page loaded and open in - "+browser+" Browser.");
		Thread.sleep(1000);		
		driver.close();

	}

}
