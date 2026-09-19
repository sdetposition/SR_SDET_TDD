package com.parabank.config;

import java.io.FileInputStream;
import java.util.Properties;

public class BrowserStackConfig {
	
	private static Properties prop;
	
	static {		
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\test\\resources\\configFiles\\browserstack.properties");
			prop.load(fis);
			
		}catch (Exception e) {
			throw new RuntimeException("Unable to Load Browserstack Properties File.",e);
		}
	}

	
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
