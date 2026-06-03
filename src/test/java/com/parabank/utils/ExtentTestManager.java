package com.parabank.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static void startTest(String testName) {
		ExtentTest eTest = ExtentManager.getExtentInstance().createTest(testName);
		
		test.set(eTest);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
}
