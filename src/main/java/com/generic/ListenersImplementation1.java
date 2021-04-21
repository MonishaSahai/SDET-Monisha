package com.generic;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation1 implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		//System.out.println("Test Execution Started");
	}
	
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Good job Test is success");
	}
	
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		//System.out.println("OOPS TC got failed");
		//screenshot capturing
		//System.out.println("Execution failed Screenshot taken");
		EventFiringWebDriver efwd = new EventFiringWebDriver(BaseClass.driver1);
		File screenshot = efwd.getScreenshotAs(OutputType.FILE);
		try {
			  FileUtils.copyFile(screenshot, new File("./screenshot/"+ name +".png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	public void onTestSkipped(ITestResult result) {
		//System.out.println("OOPS TC got Skipped");
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//System.out.println("failed but within success percantage");
	}

	public void onFinish(ITestContext result) {
		//System.out.println("Execution Success");
	}
	
	public void onStart(ITestContext result) {
		//System.out.println("Execution Started");
	}
}
