package com.scmp.Core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements  ITestListener
{

	@Override
	public void onFinish(ITestContext result) 
	{
		System.out.println("Test Case failed and details are" +" "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test case started and details are"+" "+ result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("Test Case Failed with success percentage and details are"+" "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test case Failed and details are"+" "+ result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test case skipped and details are"+" "+ result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("On start of test case and details are "+ " "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Result of test case and details are"+" "+result.getName());
		
	}

}