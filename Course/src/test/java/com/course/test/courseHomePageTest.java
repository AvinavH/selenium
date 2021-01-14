package com.course.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.course.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.course.Pages.HomePage;
import com.course.Pages.SecondPage;
import com.course.Util.Time;
import com.course.Util.captureScreen;

public class courseHomePageTest extends TestBase {
	HomePage home;
	SecondPage second;
	ExtentReports extent;
    ExtentTest test;
	public courseHomePageTest()
	{
		super();	
	}
	@BeforeTest
	public void setUp() throws IOException
	{
		extent = new ExtentReports("C:\\Users\\avina\\eclipse-workspace\\Course\\test-output\\CourseraExtentReport.html",true);
		initialization();
		home = new HomePage();
	}
	@Test(priority=1,groups= {"smoke","regression"})
	public void HomePageValidationTest()
	{
		test = extent.startTest("Home Page Validation Test");
		Assert.assertTrue(home.checkHomePage(), "Home Page Error!!");
	}
	@Test(priority=2, groups= {"smoke"})
	public void logoVerificationTest()
	{
		test = extent.startTest("Logo Verification Test");
		Assert.assertTrue(home.validateLogo(), "Logo is not visible!!");
	}
	@Test(priority=3, groups= {"smoke"})
	public void searchFieldSmokeTest()
	{
		test = extent.startTest("Search Field Verification Test");
		Assert.assertTrue(home.checkSearchField(), "SearchField smoke Test failed!!");
	}
	@Test(priority=4, groups= {"smoke"})
	public void searchButtonSmokeTest()
	{
		test = extent.startTest("Search Button Verification Test");
		Assert.assertTrue(home.checkSearchButton(), "SearchButton smoke Test failed!!");
	}
	@Test(priority=5,groups= {"smoke"})
	public void exploreButtonSmokeTest()
	{
		test = extent.startTest("Explore Button Verification Test");
		Assert.assertTrue(home.checkExploreButton(), "Explore Button is not visible!!");
	}
	@Test(priority=6,groups="regression")
	public void navigateToSecondPageTest()
	{
		test = extent.startTest("Second Page Navigation Test");
		second=home.navigateToSecondPage();
		Assert.assertTrue(second.checkSecondPage(), "Web site has not navigated to second Page");
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	 {
		test.setStartedTime(Time.getTime(result.getStartMillis()));
		test.setEndedTime(Time.getTime(result.getEndMillis()));
		for (String group : result.getMethod().getGroups())
			test.assignCategory(group);
		 if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath" //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
			  String screenshotPath = captureScreen.screenCapture(result.getName());
			 //To add it in the extent report
			 test.log(LogStatus.FAIL,test.addScreenCapture(screenshotPath));
			 }else if(result.getStatus() == ITestResult.SKIP){
			 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			 }
			 else if(result.getStatus() == ITestResult.SUCCESS)
			 {
				 test.log(LogStatus.PASS, "Test Case passed is "+result.getName()); 
			 }
			 // ending test
			 //endTest(test) : It ends the current test and prepares to create HTML report
			 extent.endTest(test);
	 }
	@AfterTest
	public void tearDown() 
	{
		
		extent.flush();
        extent.close();
        driver.close();
	}
	

}
