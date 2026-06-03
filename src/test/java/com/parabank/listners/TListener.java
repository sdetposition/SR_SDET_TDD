package com.parabank.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.parabank.utils.ExtentManager;
import com.parabank.utils.ExtentTestManager;

public class TListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().info("Test Started");
		System.out.println("Test Started - "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass(result.getMethod().getMethodName() + " - Test Passed");
		ExtentTestManager.getTest().pass("Test Passed ");
		System.out.println("Test Passed - "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().fail(result.getMethod().getMethodName() + " - Test Failled");
		ExtentTestManager.getTest().fail("Test Failled ");
		System.out.println("Test Faillure - "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().skip(result.getMethod().getMethodName() + " - Test Failled");
		ExtentTestManager.getTest().skip("Test Skipped ");
		System.out.println("Test Skipped - "+result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getExtentInstance().flush();
		ExtentTestManager.getTest().info("Test Finished");
		System.out.println("Test Finished - "+context.getName());
	}

}
