package com.tripadvisor.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;
import com.tripadvisor.Utility.DriverSetup;

public class tripAdvisorSmokeTest extends tripAdvisorPOF {
	Logger log= Logger.getLogger("tripAdvisorSmokeTest");
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		extent = new ExtentReports("C:\\Users\\avina\\eclipse-workspace\\TripAdvisor\\extentReportSmoke.html",true);  
	    File file = new File("C:\\Users\\avina\\eclipse-workspace\\TripAdvisor\\Config.properties");
		FileInputStream readFile= null;
		Properties prop = new Properties();
		String browser="";
		String mode="";
		
		try {
			readFile= new FileInputStream(file);
			prop.load(readFile);
			browser= prop.getProperty("Browser");
			mode = prop.getProperty("mode");
			System.out.println("Mode selected : "+mode);
			System.out.println("Browser selected: "+browser);
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		finally {
			if(readFile!= null)
				try {
					readFile.close();
				} 
				catch (IOException e) 
			    {			
					e.printStackTrace();
				}
		}
		  test =  extent.startTest("Verify Browser");
		  test.log(LogStatus.INFO, ""+browser+" Browser Invoked");
		  log.info(" "+browser+" Browser invoked");
		  driver = DriverSetup.getDriver(browser,mode);
		  driver.manage().deleteAllCookies();
		  driver.get(prop.getProperty("url"));
		  log.info("Web Site Launched");
		  test.log(LogStatus.PASS, "Website launched");
		  extent.endTest(test);
		  extent.flush();
	}
	
	//********************HomePage Logo Smoke Test***********************************//
		@Test(priority=1,groups="smoke")
		public void tripLogoSmoke() {
			ExtentTest test1= extent.startTest("Tripadvisor Logo smoke test");
			log.info("Logo test: started");
			WebElement logo= driver.findElement(Logo);
			try {
				Assert.assertTrue(logo.isDisplayed(), "Tripadvisor Logo verified");
				test1.log(LogStatus.PASS,"Tripadvisor logo test passed" );
				log.info("Tripadvisor logo test passed");
				System.out.println("Logo passed");
			}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "Tripadvisor logo test failed");
				log.info("Tripadvisor logo test failed");
			}
			 extent.endTest(test1);
			  extent.flush();
		}
		
		//********************Home Page HOTEL BUTTON SMOKE TEST***************************//	
		@Test(priority=2,groups="smoke")
		public void hotelBtnSmoke() {
			ExtentTest test1= extent.startTest("Hotel Button smoke test");
			log.info("Hotel button test: started");
			WebElement hotelBtn= driver.findElement(HotelBtn);
			try {
				Assert.assertTrue(hotelBtn.isDisplayed(), "Hotel Button verified");
				test1.log(LogStatus.PASS,"Hotel Button test passed" );
				log.info("Hotel Button test passed");
				System.out.println("Hotel Button passed");
			}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "Hotel Button test failed");
				log.info("Hotel Button test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
		//********************Home Page SEARCH FIELD SMOKE TEST***************************//	
		@Test(priority=3,groups= {"smoke", "regression"})
		public void searchFieldSmoke() {
			ExtentTest test1= extent.startTest("Search field smoke test");
			log.info("Search Field test: started");
			WebElement searchField= driver.findElement(searchDestination);
			try {
				Assert.assertTrue(searchField.isEnabled(), "Search field verified");
				searchField.sendKeys("Checking search field");
				Thread.sleep(2000);
				
				test1.log(LogStatus.PASS,"Search field test passed" );
				log.info("Search field test passed");
				System.out.println("Search field passed");
				
							
				searchField.sendKeys(Keys.CONTROL+"a");
				searchField.sendKeys(Keys.BACK_SPACE);
				test1.log(LogStatus.FAIL, "Search field not cleared");
			}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "Search field test failed");
				log.info("Search field test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
		//********************Home Page SEARCH BUTTON SMOKE TEST***************************//	
		@Test(priority=4,groups="smoke")
		public void searchBtnSmoke() {
			ExtentTest test1= extent.startTest("Search button smoke test");
			log.info("Search button test: started");
			WebElement searchField= driver.findElement(searchDestination);
			searchField.sendKeys("<--- Checking this button");
			
			WebElement searchBtn= driver.findElement(SearchBtn);
			try {
				Assert.assertTrue(searchBtn.isDisplayed(), "Search button verified");
				test1.log(LogStatus.PASS,"Search Button test passed" );
				log.info("Search Button test passed");
				System.out.println("Search Button passed");
				
				searchField.sendKeys(Keys.CONTROL+"a");
				searchField.sendKeys(Keys.BACK_SPACE);
				searchField.sendKeys(Keys.ESCAPE);
				}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "Search Button test failed");
				log.info("Search Button test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
		//----------------------------------------------NAVIGATING TO SECOND PAGE-------------------------------------------//
		
		//*************************************SECOND PAGE WINDOW HANDLE TEST************************************************//
		@Test(priority=5,groups="smoke")
		public void mumbaiHotelSmoke() {
			ExtentTest test1= extent.startTest("Search button smoke test");
			log.info("Search button test: started");
			WebElement hotelBtn= driver.findElement(HotelBtn);
			hotelBtn.click();
			WebElement search_field =driver.findElement(SearchField);
			search_field.sendKeys("mumbai");
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			WebElement mumbai = driver.findElement(city);
			WebDriverWait wait3 = new WebDriverWait(driver,50);
			wait3.until(ExpectedConditions.visibilityOf(mumbai)); 
			wait3.until(ExpectedConditions.elementToBeClickable(mumbai));
			mumbai.click();
			String expected= "https://www.tripadvisor.in/Hotels-g304554-Mumbai_Maharashtra-Hotels.html";
			String actual= driver.getCurrentUrl();
			try 
			{
				Assert.assertEquals(actual, expected, "Mumbai Hotel webpage test: verified");
				test1.log(LogStatus.PASS,"Mumbai Hotel webpage test passed" );
				log.info("Mumbai Hotel webpage test passed");
				System.out.println("Mumbai Hotel webpage test passed");
			}
			catch(Exception e) 
			{
				test1.log(LogStatus.FAIL, "Mumbai Hotel webpage test failed");
				log.info("Mumbai Hotel webpage test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
		//*************************MUMBAI HOTELS HEADING SMOKE TEST********************************//	
		@Test(priority=6,groups="smoke")
		public void mumbaiHotelHeaderSmoke() {
			ExtentTest test1= extent.startTest("Mumbai Hotels Heading smoke test");
			log.info("Mumbai Hotels Heading test: started");
			
			WebElement hotelHdr1= driver.findElement(Hotelheader1);
			String expected= "Mumbai Hotels";
			String actual= hotelHdr1.getText();
			
			WebElement hotelHdr2= driver.findElement(Hotelheader2);
			String expected2= "and Places to Stay";
			String actual2= hotelHdr2.getText();
			
			try 
			{
				Assert.assertTrue((actual.equals(expected)), "Mumbai Hotels line 1 Heading test: verified");
				Assert.assertTrue((actual2.equals(expected2)), "Mumbai Hotels line 2 Heading test: verified");
				test1.log(LogStatus.PASS,"Mumbai Hotels Heading test passed" );
				log.info("Mumbai Hotels Heading test passed");
				System.out.println("Mumbai Hotels Heading passed");
			}
			catch(Exception e) 
			{
				test1.log(LogStatus.FAIL, "Mumbai Hotels Heading test failed");
				log.info("Mumbai Hotels Heading test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
		
		//************************************CHECKIN BUTTON SMOKE TEST********************************************//
		@Test(priority=7,groups="smoke")
		public void checkinBtnSmoke() {
			ExtentTest test1= extent.startTest("CheckIN Button smoke test");
			log.info("CheckIN button test: started");
			driver.findElement(By.xpath("//h1[@class='page_h1_line1']")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			WebElement checkinBtn= driver.findElement(checkInBtn);
			try {
				Assert.assertTrue(checkinBtn.isDisplayed(), "CheckIN Button verified");
				test1.log(LogStatus.PASS,"CheckIN Button test passed" );
				log.info("CheckIN Button test passed");
				System.out.println("CheckIN Button passed");
			}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "CheckIN Button test failed");
				log.info("CheckIN Button test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
		//************************************CHECKOUT BUTTON SMOKE TEST********************************************//
		@Test(priority=8,groups="smoke")
		public void checkoutBtnSmoke() {
			ExtentTest test1= extent.startTest("CheckOUT Button smoke test");
			log.info("CheckOUT button test: started");
			WebElement checkoutBtn= driver.findElement(checkOutBtn);
			try {
				Assert.assertTrue(checkoutBtn.isDisplayed(), "CheckOUT Button verified");
				test1.log(LogStatus.PASS,"CheckOUT Button test passed" );
				log.info("CheckOUT Button test passed");
				System.out.println("CheckOUT Button passed");
			}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "CheckOUT Button test failed");
				log.info("CheckOUT Button test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		}
			
		//************************************GUEST BUTTON SMOKE TEST********************************************//	
		@Test(priority=9,groups="smoke")
		public void guestBtnSmoke() {
			ExtentTest test1= extent.startTest("Guest Button smoke test");
			log.info("Guest button test: started");
			WebElement guestBtn= driver.findElement(GuestBtn);
			try {
				Assert.assertTrue(guestBtn.isDisplayed(), "Guest Button verified");
				test1.log(LogStatus.PASS,"Guest Button test passed" );
				log.info("Guest Button test passed");
				System.out.println("Guest Button passed");
			}
			catch(Exception e){
				test1.log(LogStatus.FAIL, "Guest Button test failed");
				log.info("Guest Button test failed");
			}
			 extent.endTest(test1);
			 extent.flush();
		
	}
		//******************************************HOTEL RADIO SMOKE BUTTON*************************************************//
			@Test(priority=10,groups="smoke")
			public void hotelRadioBtnSmoke() {
				ExtentTest test1= extent.startTest("Hotel Radio Button smoke test");
				log.info("Hotel Radio button test: started");
				WebElement hotelRadioBtn= driver.findElement(HotelRadioBtn);
				try {
					Assert.assertTrue(hotelRadioBtn.isEnabled(), "Hotel Radio Button verified");
					test1.log(LogStatus.PASS,"Hotel Radio Button test passed" );
					log.info("Hotel Radio Button test passed");
					System.out.println("Hotel Radio Button passed");
				}
				catch(Exception e){
					test1.log(LogStatus.FAIL, "Hotel Radio Button test failed");
					log.info("Hotel Radio Button test failed");
				}
				 extent.endTest(test1);
				 extent.flush();
		}
		@AfterClass
		public void browserClose() {
			ExtentTest test1= extent.startTest("Closing Browser");
			log.info("Closing the Browser");
			driver.close();
			test1.log(LogStatus.PASS, "Browser Closed");
			extent.endTest(test1);
			extent.flush();
		}

}
