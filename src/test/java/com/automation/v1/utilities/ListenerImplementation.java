package com.automation.v1.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	@Override
	    public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	    }
	
	    @Override
	    public void onFinish(ITestContext context) {
	    	System.out.println("Completed");
	    }
	
	    @Override
	    public void onTestStart(ITestResult result) {
	    	System.out.println("Test Started");	
	    }
	
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	System.out.println("Test Passed");
	    }
	
	    @Override
	    public void onTestFailure(ITestResult result) {
	    	System.out.println("Test Failed");
	    }
	
	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	System.out.println("Test Skipped");
	    }
	
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    	System.out.println("Passed with some Failure");
	    }
	

}
