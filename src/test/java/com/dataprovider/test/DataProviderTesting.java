package com.dataprovider.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTesting {
	
	/* Before running this program from testng.xml file follow the below :
	 * Copy the relevent testngxml file configurations from src/resources/testngxmlbackup
	 */
	
	static WebDriver driver;
	@BeforeMethod
	@Parameters({"username","password"})
	public void setup(String username, String password)
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.get("https://www.amazon.in/");
	    
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='continue' and @type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		driver.findElement(By.xpath("//img[@alt='Your Addresses']")).click();
	}
	
	@DataProvider(name="getData")
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider="getData")
	public void initialTest(String fullName, String phoneNumber, String pincode, String streetAddress, String city) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(text(),'Add address')]")).click();
		driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressFullName']")).sendKeys(fullName);
		driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys((phoneNumber)); //using stringvalueof as sendkeys doesnt allow to enter a value into numeric field such as accountnumber or amount
		driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressPostalCode']")).sendKeys((pincode));
		driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressLine1']")).sendKeys(streetAddress);
		Thread.sleep(2000);
	    WebElement submitButton=driver.findElement(By.xpath("//span[@id='a-autoid-0']/child::span"));
	    submitButton.click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
