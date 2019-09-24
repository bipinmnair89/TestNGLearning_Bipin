package com.testNGLearning.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SecondTestNGValidation {
	
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
		driver.get("https://www.kittysplit.com/en/");
	}
	
	@Test(priority=0,groups= {"Title"})
	public void validatePageTitleKitty()
	{
		String pageTitle=driver.getTitle();
		System.out.println("Value of Page Title is :"+pageTitle);
		Assert.assertEquals("Kittysplit - Easy splitting of group expenses", pageTitle);
	}
	
	@Test(priority=1)
	public void validateStartNowBtn()
	{
		WebElement startNowBtn=driver.findElement(By.xpath("//*[text()='Start now']"));
		Boolean value=startNowBtn.isEnabled();
		Assert.assertTrue(value);
		startNowBtn.click();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing the browser");
		driver.close();
	}
	
	
}
