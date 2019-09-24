package com.failedTestScreenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShotBase {

	public static WebDriver driver;
	public static void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login?lang=en");
	}
	
	public static void getScreenShot(String filename) throws IOException
	{
		TakesScreenshot scrShot=((TakesScreenshot)driver);
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D://Learning//Workspace//TestNGLearningProject//src//resources//screenshots//fail_"+filename+".png"));
	
		System.out.println("Test case failed");
	}
}
