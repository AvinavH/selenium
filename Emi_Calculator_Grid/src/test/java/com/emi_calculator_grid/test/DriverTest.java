package com.emi_calculator_grid.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.emi_calculator_grid.input.Driver_setup;
import com.emi_calculator_grid.input.Read_xlsx;
import com.emi_calculator_grid.output.Screenshots;
import com.emi_calculator_grid.output.Write_xlsx;
import com.emi_calculator_grid.utilities.Loan_detailes;

@Listeners(com.emi_calculator_grid.output.TestListeners.class)
public class DriverTest {
	
//"Find the interest amount for current year for:
//1. Buying a  car of 15 Lac
//2. Interest rate of 9.5% 
//3. Tenure should be 1 year.
//Display the interest amount & principal amount of first month.
//(Suggested Site: emicalculator.net  / HDFCbank.com etc. however you are free to use any other legitimate site)"
	
	
	
	 static WebDriver driver;
	 
	 
	 
	 ExtentHtmlReporter htmlReporter;
	    
	    ExtentReports extent;
	    //helps to generate the logs in test report.
	    ExtentTest test;
	    Logger log = LogManager.getLogger("DriverTest.class");
	 	
		
		@BeforeClass
		@Parameters({"Browser" ,"url"})
		public void driver_ready(String Browser,String url) throws IOException {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Extent_Report.html");
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Browser", Browser);
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	        htmlReporter.config().setDocumentTitle("Emi Calculator");
	        htmlReporter.config().setReportName("Automation Execution Report");
	        htmlReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
			
			if(Browser.equalsIgnoreCase("Chrome")) {
				
				Driver_setup obj = new Driver_setup();
				
				driver=obj.getChromeDriver();
				log.info("*******Launching Chrome Driver**********");
				
				
			}
			
			
			else if(Browser.equalsIgnoreCase("Firefox")) {
				
				
Driver_setup obj = new Driver_setup();
				
				driver=obj.getFirefoxDriver();
				log.info("*********Launching Firefox Driver*********");
			}
			
			
			driver.manage().window().maximize();
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			
			//Loan_detailes obj2 = new Loan_detailes();
			//obj2.setup_driver(driver);
			
		}
		
		
		@Test(priority=1,groups="Check Title")
		public void emicalculator_TitleTest() {
			String title=driver.getTitle();
			test = extent.createTest("emicalculator_test","passed");
			//System.out.println(title);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Assert.assertEquals(title, "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
			log.info("*******Checking Page Tittle************");
		}
		
		
		
		@Test(priority=2,dependsOnMethods="emicalculator_TitleTest")
		public void select_homeloan() {
			
			test = extent.createTest("select_car","failed");	
			Loan_detailes obj2 = new Loan_detailes(driver);
			obj2.select_homeloan();
			//String title=driver.getClass();
			SoftAssert as =new SoftAssert();
			as.assertTrue(obj2.carloan_isSelected());
			log.info("select_Car FAILED test case");
		}
		
		@Test(priority=3,dependsOnMethods="emicalculator_TitleTest")
		public void select_personalloan() {
			
			test = extent.createTest("select_car","failed");	
			Loan_detailes obj2 = new Loan_detailes(driver);
			obj2.select_personalloan();
			//Assert.assertFalse(.isSelected,"Car_loan not selected");
			SoftAssert as =new SoftAssert();
			as.assertTrue(obj2.carloan_isSelected());
			log.info("select_Car FAILED test case");
		}
		
		@Test(priority=4,dependsOnMethods="emicalculator_TitleTest",groups="Select Tab for Car Loan")
		public void select_Car() {
			
			test = extent.createTest("select_car","passed");	
			Loan_detailes obj2 = new Loan_detailes(driver);
			obj2.select_carloan();
			Assert.assertTrue(obj2.carloan_isSelected());
			log.info("Selecting the Car Loan option through "+"driver");
		}
		
		
		@Test(priority=5,dependsOnMethods="emicalculator_TitleTest",groups="EMI Calculation Test")
		public void sent_ammount() throws IOException {
			Read_xlsx obj3=new Read_xlsx();
			Loan_detailes obj2 = new Loan_detailes(driver);
			Row row=obj3.input_file();
			String amount =obj3.input_loan_amount(row);
			//System.out.println(amount);
			obj2.send_amount(amount);
			Assert.assertNotNull(obj2);
			test = extent.createTest("sent_ammount","passed");
			log.info("Writing the amount="+amount+" for the Car Loan");
		}
		
		@Test(priority=6,dependsOnMethods="emicalculator_TitleTest",groups="EMI Calculation Test")
		public void sent_interest() throws IOException {
			Read_xlsx obj3=new Read_xlsx();
			Loan_detailes obj2 = new Loan_detailes(driver);
			Row row=obj3.input_file();
			String interest =obj3.input_loan_interest(row);
			obj2.send_interest(interest);
			Assert.assertNotNull(obj2);
			test = extent.createTest("sent_interest","passed");
			log.info("Writing the interest="+interest+" for the Car Loan");
		}
		
		@Test(priority=7,dependsOnMethods="emicalculator_TitleTest",groups="EMI Calculation Test")
		public void sent_tennure() throws IOException {
			Read_xlsx obj3=new Read_xlsx();
			Loan_detailes obj2 = new Loan_detailes(driver);
			Row row=obj3.input_file();
			String tennure =obj3.input_loan_tennure(row);
			obj2.send_tennure(tennure);
			WebDriverWait wait = new WebDriverWait(driver,6);
			Assert.assertNotNull(obj2);
			test = extent.createTest("sent_tennure","passed");
			log.info("Writing the interest="+tennure+" for the Car Loan");
			
			
		}
		@Test(priority=8,dependsOnMethods="sent_tennure",groups="Outputs")
		public void screenshots_of_Sendkeys() throws IOException {
			
			//test = extent.createTest("screenshots_of_Sendkeys","passed");		
			Screenshots obj=new Screenshots();
			obj.Screenshot(driver);
			Assert.assertNotNull(obj);
			test = extent.createTest("screenshots_of_Sendkeys","passed");		
			log.info("Taking Screenshot");
		}
		
		
		@Test(priority=9,dependsOnMethods="screenshots_of_Sendkeys",groups="Scroll down")
		public void scroll_to_required_data() throws InterruptedException {
			
			//test = extent.createTest("scroll_to_required_data","passed");
			Loan_detailes obj2 = new Loan_detailes(driver);
			obj2.scroll();
			log.info("Scrolling down to the location to show the first month principal and the interest");
			Assert.assertNotNull(obj2);
			test = extent.createTest("scroll_to_required_data","passed");
		}
		
		@Test(priority=10,dependsOnMethods="scroll_to_required_data",groups="Expand List")
		public void expand_interest_amounts() throws InterruptedException {
			
			//test = extent.createTest("expand_interest_amounts","passed");
			Loan_detailes obj2 = new Loan_detailes(driver);
			obj2.expand_list();
			Assert.assertNotNull(obj2);
			test = extent.createTest("expand_interest_amounts","passed");
			log.info("Expanding the List to have a detailed view of the Principal and the intrest for First Month");
		}
		
		
		
		@Test(priority=11,dependsOnMethods="expand_interest_amounts",groups="Outputs")
		public void screenshots_of_FirstMonthCredentials() throws IOException {
			
			//test = extent.createTest("screenshots_of_FirstMonthCredentials","passed");
			Screenshots obj=new Screenshots();
			obj.Screenshot(driver);
			Assert.assertNotNull(obj);
			test = extent.createTest("screenshots_of_FirstMonthCredentials","passed");
			log.info("Taking Screenshot of the Payable principal and the interest");
		}
		
		@Test(priority=12,dependsOnMethods="expand_interest_amounts",groups="Outputs")
		public void write_interest() throws IOException {
			
			//test = extent.createTest("write_interest","passed");
			Loan_detailes obj2 = new Loan_detailes(driver);
			Write_xlsx obj4 = new Write_xlsx();
			String interest_ammount=obj2.select_interest();
			obj4.write_interestAmmout(interest_ammount);
			Assert.assertNotNull(obj4);
			test = extent.createTest("write_interest","passed");
			log.info("Writing the Interest amount in a excel log, which is = "+interest_ammount);
		}
		
		@Test(priority=13,dependsOnMethods="expand_interest_amounts",groups="Outputs")
		public void write_principle() throws IOException {
			
			test = extent.createTest("write_principle","passed");
			Loan_detailes obj2 = new Loan_detailes(driver);
			Write_xlsx obj4 = new Write_xlsx();
			String principle_ammount=obj2.select_Principle();
			obj4.write_principleAmmout(principle_ammount);
			Assert.assertNotNull(obj4);
			test = extent.createTest("write_principle","passed");
			log.info("Writing the Principal amount in a excel log, which is = "+principle_ammount);
		}
		
		//@AfterTest
		public void failure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getTestName() + "– Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
			MarkupHelper.createLabel(result.getThrowable() + " – Test Case Failed", ExtentColor.RED));
			// Here you can add screenshot in the report for fail case
			test.fail(result.getName() + "Test Step Failed");
			}
			if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
			MarkupHelper.createLabel(result.getName() + "– Test Case Skipped", ExtentColor.ORANGE));
			test.skip(result.getName() + "Test Step Skipped");
			}
			if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS,
			MarkupHelper.createLabel(result.getName() + "Test Case PASSED", ExtentColor.GREEN));
			test.pass(result.getName() + "Test Step Passed");
			}
			}
		
		
		
		
		  
		
		@AfterTest
		public void exit() {
			driver.quit();
			log.info("Quiting the Browser");
			extent.flush();
		}

		
		

}
