package com.failedTestScreenshots;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;;

public class CustomListener extends TakeScreenShotBase implements ITestListener{

		  public void onTestStart(ITestResult result) {
		    // not implemented
		  }

		  public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

		  public void onTestFailure(ITestResult result) {
			  
			  System.out.println("Method failed : "+result.getMethod().getMethodName());
			  try {
				getScreenShot(result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}			  
		  

		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		  public void onFinish(ITestContext context) {
		    // not implemented
		  }

}
