package designPatterns.factoryPattern;

public class DriverManagerFactory {
	public static DriverManager driverManager;
	
	public static DriverManager getDriverManager(DriverType browser) {
		
		switch (browser) {
		case CHROME:
			driverManager = new ChromeDriverManager();			
			break;
			
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
			
		case IE:
			driverManager = new IEDriverManager();	
			break;

		default: System.out.println("Selected Driver is not Implemented..!");
			break;
		}		
		return driverManager;
	}

}
