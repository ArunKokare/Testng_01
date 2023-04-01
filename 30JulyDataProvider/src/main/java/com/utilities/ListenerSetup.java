package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup extends com.testBase.TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) 
	{
	  System.out.println("Testcase Execution Started"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Testcase Execution Successfully"+result.getName());
		ReadData rd =new ReadData();
	//	rd.writeData("Login Data", 0, 0, null);

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Testcase Execution Failure"+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Testcase Execution Skipped"+result.getName());
	}

	
	
	

}
