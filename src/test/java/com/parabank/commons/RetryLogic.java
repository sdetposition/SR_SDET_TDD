package com.parabank.commons;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	public int maxCount = 2;
	public int reTryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		
		if(reTryCount < maxCount) {
			reTryCount++;
			return true;
		}		
		return false;
	}

}
