package com.report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerDemo implements ITestListener{
	
	/*
	 * Before execution of any test case create a test for the extent report
	 * Test name will be the same as test case method name
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportUtils.createTest(result.getMethod().getMethodName());

	}



	@Override
	public void onFinish(ITestContext context) {
		ExtentReportUtils.flushReport();
	}

}
