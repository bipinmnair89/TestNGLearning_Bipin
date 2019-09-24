package com.testNGLearning.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import junit.framework.Assert;

/* Run this program without testng.xml file
 * To take screenshot for failed tc we have used 3 classes 
 *      ValidateFailedTestScreenshots , CustomListener, TakeScreenShotBase
 * 
 * here we need to use WebDriver in all 3 classes as screenshot method is dependent on the same
 * hence we initialize the Webdriver in TakeScreenShotBase class and extend this class to both other classes
 * If we specify the webdriver on multiple classes then high chances are there that we will encounter nullpointer exception
 * 
 * In the test class - ValidateFailedTestScreenshots , we specify the listener class on the top
 * 
 * In the CustomListener class we implement the interface ITestListener and call the code in Override failed class
 * 
 * We also use the ITestResult methods to get the name of the failed method and pass it to the screenshot 
 * class so that we have individual names for the screenshots
 */

@Listeners(com.failedTestScreenshots.CustomListener.class)  //giving the location of the listener class

public class ValidateFailedTestScreenshots extends com.failedTestScreenshots.TakeScreenShotBase {
	
	@BeforeMethod
	public void initialSetup()
	{
		initialization();
	}
	
	@Test(priority=0)
	public void validatePageTitle()
	{
		String actualPageTitle=driver.getTitle();
		String expectedValue="Login ond Twitter";
		System.out.println("Actual value of Page Title is :"+actualPageTitle);
		Assert.assertEquals(expectedValue, actualPageTitle); //deliberately giving to make this testcase fail
	}
	
	@Test(priority=1)
	public void enterCredentials()
	{
		Assert.assertEquals(true, false); //deliberately giving to make this testcase fail
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
