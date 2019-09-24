package com.testNGLearning.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testNGLearning.Resources.DriverInitializationClass;

public class TestNGParallelExecutionConcept extends com.testNGLearning.Resources.DriverInitializationClass{

	/* Parallel test execution can be performed on Tests, Classes and Methods. This is an example of 'Tests'
	 * here to avoid nullpointer exception WebDriver is declared in another class and its inherited
	 * This test needs to be run with testng.xml as in the suite tag we specify the parallel execution value as
	 * for tests = parallel="tests"
	 * for classes = parallel="classes"
	 * for methods = parallel="methods"
	 * Also the thread-count value must be specified in the suite and must not be less than the number of tests/classes/methods to be executed	
	 */
	
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browser)
	{
		if(browser.equals("chrome"))
		{
			//WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://twitter.com/login?lang=en");
		}
		else if(browser.equals("firefox"))
		{
			//WebDriver driver;
			System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.facebook.com");   //not loading url on firefox might be some threading concept issue
		}
	}
	
	@Test
	public void validateEffort()
	{
		System.out.println("TestCase");
		//String title=driver.getTitle();
		//System.out.println("Title of the page is : "+title);
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}

}
