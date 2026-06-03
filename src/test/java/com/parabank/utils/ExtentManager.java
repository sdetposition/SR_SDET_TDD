package com.parabank.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtentInstance(){
		if(extent == null) {
			
			ExtentSparkReporter spark = new ExtentSparkReporter(new File("reports/ParaBank_ExtentReport.html"));
			
			spark.config().setDocumentTitle("ParaBank Reports");
			spark.config().setReportName("UI Extent Reports");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Project", "UI Automation Framework");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Tester", "Automation Team");	
			
		}
		return extent;
	}
}
