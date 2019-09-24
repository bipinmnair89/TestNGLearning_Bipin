package com.testNGLearning.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.*;

public class AssertionsAndSkipTest {
	
	//can directly run this program without testNG.xml file
	
	public static WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login?lang=en");
	}
	
	@Test
	public void executeHardAssert()
	{
		Assert.assertEquals(true, false, "Validation of hard assertfailed");
		System.out.println("Post Statement 1");
	}
	
	@Test
	public void executeSoftAssert()
	{
		SoftAssert sAssert=new SoftAssert();  /*better to create softassert object inside the test case as
												if we are creating it on class level then it will show the execution
												details of all the softassert conditions if there are multiple cases
											  */
		
		sAssert.assertEquals(true, false); 			//will return false
		System.out.println("Statement 1");
		System.out.println("Statement 2");
		System.out.println("Statement 3");
		sAssert.assertAll();						//if we dont give this statement then the testcase will be Passed instead of failed
	}
	
	@Test
	public void skipTestFeature()
	{
		System.out.println("Dummy testcase to show how test case can be skipped in testng");
		
		throw new SkipException("Test Case 3 to be skipped");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
	

}
