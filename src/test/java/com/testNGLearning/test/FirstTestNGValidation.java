package com.testNGLearning.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FirstTestNGValidation {
	
	/* Before running this program from testng.xml file follow the below :
	 * Copy the relevent testngxml file configurations from src/resources/testngxmlbackup
	 *  */
	
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
	
	@Test(priority=0,groups= {"Title"},description="First TC")
	public void validatePageTitle()
	{
		String actualPageTitle=driver.getTitle();
		String expectedValue="Login on Twitter";
		System.out.println("Value of Page Title is :"+actualPageTitle);
		Assert.assertEquals(expectedValue, actualPageTitle);
	}
	
	@Test(priority=1,groups= {"Login"},dependsOnMethods= {"validatePageTitle"},invocationCount=1)
	@Parameters({"username","password"})
	public void enterCredentials(String username, String password)
	{
		WebElement userName=driver.findElement(By.xpath("//div[@class='clearfix field']/child::input[@name='session[username_or_email]']"));
		WebElement passWord=driver.findElement(By.xpath("//div[@class='clearfix field']/child::input[@name='session[password]']"));
		userName.sendKeys(username);
		passWord.sendKeys(password);
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing the browser");
		driver.close();
	}

}
