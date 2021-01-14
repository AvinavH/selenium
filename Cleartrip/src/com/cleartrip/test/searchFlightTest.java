package com.cleartrip.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cleartrip.base.BasePage;
import com.cleartrip.pages.searchFlightPage;
import com.cleartrip.util.captureScreen;
public class searchFlightTest {
	
static WebDriver driver;
	
	
	@BeforeTest
	@Parameters({"Browser" ,"url"})                   //for passing the parameters from testng.xml file
	public void setup(String Browser, String url) {
		driver=BasePage.launchUrl(Browser, url);     //launching the URL	
	}
	
	@Test
	public void SearchTest() throws InterruptedException, IOException  // performing the operation
	{
		searchFlightPage flight = new searchFlightPage(driver);
		flight.select_roundtrip();                                   // Select trip as round trip
		flight.select_Source();										// Enter Source
		flight.select_Dest();										// Enter Destination
		flight.deprtDate();											// Select Departure Date
		flight.returnDate();										// Select Return Date
		flight.select_Adult();										// Select No. of adults
		flight.clickOnSearch();										// Click on Search 
		Thread.sleep(5000);											
		captureScreen.Screenshot(driver);            				 // Capturing screenshot
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();  // closing down browser
	}
	


}
