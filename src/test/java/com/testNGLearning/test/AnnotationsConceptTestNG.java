package com.testNGLearning.test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsConceptTestNG {
	
	
	@BeforeSuite
	public void initialSetup()
	{
		System.out.println("BeforeSuite ---->");
	}
	@BeforeTest
	public void execInitialSetup()
	{
		System.out.println("BeforeTest ---->");
	}
	@BeforeClass
	public void baseInitialisation1()
	{
		System.out.println("BeforeClass ---->");
	}
	
	@BeforeMethod
	public void makeStableSetup()
	{
		System.out.println("BeforeMethod ---->");
	}
	@Test
	public void testMethodLogin()
	{
		System.out.println("Testcase execution 1");
	}
	@Test
	public void testMethodInitial()  //gets executed before testMethodLogin() as execution happens alphabetically if priority is not determined
	{
		System.out.println("Testcase execution 0");
	}
	@AfterMethod
	public void closeStableSetup()
	{
		System.out.println("afterMethod ---->");
	}
	@AfterClass
	public void baseTearDown()
	{
		System.out.println("AfterClass ---->");
	}
	@AfterTest
	public void execInitialTearDown()
	{
		System.out.println("AfterTest ---->");
		
	}
	@AfterSuite
	public void finalClose()
	{
		System.out.println("AfterSuite ---->");
	}

}
