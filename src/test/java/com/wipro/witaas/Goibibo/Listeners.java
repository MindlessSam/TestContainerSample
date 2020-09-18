/*
package com.wipro.witaas.Goibibo;

import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;

 

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.wipro.Resources.BaseTest;

import com.wipro.Resources.ExtentReporterNG;

 

public class Listeners extends BaseTest implements ITestListener {

	 ExtentTest test;

     ExtentReports extent = ExtentReporterNG.getReportObject();

     ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();



    

     public void onTestStart(ITestResult result) {

                     test = extent.createTest(result.getMethod().getMethodName());

                     extentTest.set(test);

     }



    

     public void onTestSuccess(ITestResult result) {

                     extentTest.get().log(Status.PASS, "Test Passed!");

     }



    

     public void onTestFailure(ITestResult result) {

                     extentTest.get().fail(result.getThrowable());

                    

                     String testMethodName = result.getMethod().getMethodName();

                     try{

                                     driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

                     }

                     catch(Exception e) {

                                     e.printStackTrace();

                                    

                     }

                    

                     try {

                                    

                                     extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), testMethodName);

                     }

                     catch(Exception e) {

                                     e.printStackTrace();

                     }

     }

     public void onFinish(ITestContext context) {

                     extent.flush();

     }





	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}





	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}





	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

    

    



}


*/
