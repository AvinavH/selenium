package com.course.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.course.Pages.HomePage;
import com.course.Pages.SecondPage;
import com.course.Util.ExcelWriter;
import com.course.Util.Time;
import com.course.Util.captureScreen;
import com.course.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class courseSecondPageTest extends TestBase {
	ExtentReports extent;
    ExtentTest test;
	HomePage home;
	SecondPage second;
	
	public courseSecondPageTest()
	{
		super();
	}
	@BeforeTest(alwaysRun=true)
	public void setUp() throws IOException
	{
		extent = new ExtentReports("C:\\Users\\avina\\eclipse-workspace\\Course\\test-output\\CourseraExtentReport.html",false);
		initialization();
		home = new HomePage();
		second = home.navigateToSecondPage();
	}
	@Test(priority=1,groups= {"smoke","regression"})
	public void verifySecondPageTest()
	{
		test = extent.startTest("Verify SecondPage Test");
		Assert.assertTrue(second.checkSecondPage(), "Page Mismatch!!");
	}
	@Test(priority=2, groups= {"smoke"})
	public void verifyDomainNameTest()
	{
		test = extent.startTest("Verify Domain Name Test");
		Assert.assertTrue(second.validateDomainName(), "Domain Name Error!!");
	}
	@Test(priority=3, groups= {"smoke","regression"})
	public void skillButtonVisibilityTest()
	{
		test = extent.startTest("Skill Button Verification Test");
		Assert.assertTrue(second.validateSkillFilter(), "Skill Filter is not visible!");
	}
	@Test(priority=5,groups= {"regression"})
	public void setValidSkillFilterTest()
	{
		test = extent.startTest("Set Valid Skill Filter Test");
		second.setSkillsFilter("web development");
		Assert.assertTrue(second.checkSkillsFilter(),"Skill is not selected properly!!");
	}
	@Test(priority=4,groups= {"negative"})
	public void setInvalidSkillsTest1()
	{
		test = extent.startTest("Set InValid Skill Filter Test: 1");
		SoftAssert softAssert = new SoftAssert();
		second.setSkillsFilter("abcdef");
		softAssert.assertTrue(second.checkinputSkill(), "No such courses available");
		softAssert.assertAll();
	}
	@Test(priority=4,groups= {"negative"})
	public void setInvalidSkillsTest2()
	{
		test = extent.startTest("Set InValid Skill Filter Test: 2");
		SoftAssert softAssert = new SoftAssert();
		second.setSkillsFilter("1234");
		softAssert.assertTrue(second.checkinputSkill(), "No such courses available");
		softAssert.assertAll();
	}
	@Test(priority=4,groups= {"negative"})
	public void setInvalidSkillsTest3()
	{
		test = extent.startTest("Set InValid Skill Filter Test: 3");
		SoftAssert softAssert = new SoftAssert();
		second.setSkillsFilter("webdevelopment123");
		softAssert.assertTrue(second.checkinputSkill(), "No such courses available");
		softAssert.assertAll();
	}
	@Test(priority=6, groups= {"smoke","regression"})
	public void LevelButtonVisibilityTest()
	{
		test = extent.startTest("Level Button Verification Test");
		Assert.assertTrue(second.validateLevelFilter(), "Level Filter is not visible!");
	}
	@Test(priority=7, groups= {"regression"})
	public void setLevelFilterTest()
	{
		test = extent.startTest("Set Level Filter Test");
		second.setLevelFilter();
		Assert.assertTrue(second.checkLevelFilter(), "Level is not selected correctly!!");
	}
	@Test(priority=8, groups= {"smoke","regression"})
	public void LanguageButtonVisibilityTest()
	{
		test = extent.startTest("Language Button Verification Test");
		Assert.assertTrue(second.validateLanguageFilter(), "Language Filter is not  visible!");
	}
	@Test(priority=9, groups= {"negative"})
	public void setInvalidLanguageTest1()
	{
		test = extent.startTest("Set InValid Language Filter Test: 1");
		SoftAssert softAssert = new SoftAssert();
		second.setLanguageFilter("eNli");
		softAssert.assertTrue(second.checkinputLanguage(), "No such Languages available");
		softAssert.assertAll();
	}
	@Test(priority=9, groups= {"negative"})
	public void setInvalidLanguageTest2()
	{
		test = extent.startTest("Set InValid Language Filter Test: 2");
		SoftAssert softAssert = new SoftAssert();
		second.setLanguageFilter("egl1s8");
		softAssert.assertTrue(second.checkinputLanguage(), "No such Languages available");
		softAssert.assertAll();
	}
	@Test(priority=9, groups= {"negative"})
	public void setInvalidLanguageTest3()
	{
		test = extent.startTest("Set InValid Language Filter Test: 3");
		SoftAssert softAssert = new SoftAssert();
		second.setLanguageFilter("english123");
		softAssert.assertTrue(second.checkinputLanguage(), "No such Languages available");
		softAssert.assertAll();
	}
	@Test(priority=10, groups= {"regression"})
	public void setValidLanguageFilterTest()
	{
		test = extent.startTest("Set Valid Language Filter Test");
		second.setLanguageFilter("English");
		Assert.assertTrue(second.checkLanguageFilter(), "Language is not selected properly!!");
	}
	@Test(priority=11, groups= {"smoke","regression"})
	public void ApplyButtonVisibilityTest()
	{
		test = extent.startTest("Apply Button Verification Test");
		Assert.assertTrue(second.validateApplyButton(), "Apply Button is not visible!");
	}
	@Test(priority=12, groups= {"regression"})
	public void applyFiltersTest()
	{
		test = extent.startTest("Set Apply Filter Test");
		second.applyFilters();
		Assert.assertTrue(second.checkApply(), "No search results found!!");
	}
	@Test(priority=13 , groups= {"regression"})
	public void getFirstCourseInfoTest() throws FileNotFoundException, IOException
	{
		test = extent.startTest("Get First Course Info Test");
		ExcelWriter write = new ExcelWriter();
		write.courseInfo1();
	}
	@Test(priority=14 , groups= {"regression"})
	public void getSecondCourseInfoTest() throws FileNotFoundException, IOException
	{
		test = extent.startTest("Get Second Course Info Test");
		ExcelWriter write = new ExcelWriter();
		write.courseInfo2();
		captureScreen ss = new captureScreen();
		ss.ScreenShot();
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
			 test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
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
	@AfterTest(alwaysRun=true)
	public void tearDown()
	{
		
		extent.flush();
        extent.close();
        driver.close();
	}

}
