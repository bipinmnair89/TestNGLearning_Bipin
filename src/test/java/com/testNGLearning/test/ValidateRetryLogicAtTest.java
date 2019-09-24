package com.testNGLearning.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateRetryLogicAtTest {
	
	//run directly without testng.xml
	
	static WebDriver driver;
	@BeforeMethod
	public void initialSetup()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login?lang=en");
	}
	
	@Test(retryAnalyzer=com.retryLogicAnalyzers.RetryAnalyzer.class)
	public void validatePageTitle()
	{
		String actualPageTitle=driver.getTitle();
		String expectedValue="Login on Twitter123"; //knowingly trying to make the testcase fail by giving incorrect expected text
		System.out.println("Value of Page Title is :"+actualPageTitle);
		Assert.assertEquals(expectedValue, actualPageTitle);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing the browser");
		driver.close();
	}
	
	
	
}
