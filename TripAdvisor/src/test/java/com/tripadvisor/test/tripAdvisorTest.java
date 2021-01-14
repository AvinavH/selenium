package com.tripadvisor.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tripadvisor.Filters.DatePicker;
import com.tripadvisor.Filters.Update;
import com.tripadvisor.Filters.checkDates;
import com.tripadvisor.Filters.checkPages;
import com.tripadvisor.Filters.checkPrice;
import com.tripadvisor.Filters.setLocation;
import com.tripadvisor.Filters.setPriceSliders;
import com.tripadvisor.Filters.setSearchType;
import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;
import com.tripadvisor.Utility.DriverSetup;
import com.tripadvisor.Utility.ExcelWriter;

public class tripAdvisorTest extends tripAdvisorPOF {
	
	Logger log= Logger.getLogger("tripAdvisorTest");
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		extent = new ExtentReports("C:\\Users\\avina\\eclipse-workspace\\TripAdvisor\\extentReport.html",true);  
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
	//**************************** HomePage Test ***********************************//
	@Test(priority=1,groups={"regression"})
	public void homePageTest()
	{
	   test =  extent.startTest("Verify Home Page");
	   test.log(LogStatus.INFO, "Verifying Home Page");
	   checkPages homePage = new checkPages();
	   boolean flag = homePage.checkHome(driver);
	   try
	   {
	   Assert.assertTrue(flag,"Home Page ERROR");
	   test.log(LogStatus.PASS,"Website is launched at the home page successfully");
	   }
	   catch(Exception e)
	   {
		   test.log(LogStatus.FAIL,"Website is not launched at the home page successfully" );
	   }
	   extent.endTest(test);
	   extent.flush();
	}
	//**************************** Second Page Navigation and Verification ***********************************//
	@Test(priority=2,dependsOnMethods="homePageTest",groups={"regression"})
	public void secondPageTest()
	{
		test = extent.startTest("Verify Second Page");
		test.log(LogStatus.INFO, "Verifying Second Page");
		setLocation loc = new setLocation();
		loc.location(driver);
		test.log(LogStatus.INFO, "Destination has been entered");
		checkPages secondPage = new checkPages();
		boolean flag = secondPage.checkSecondPage(driver);
		try
		{
		Assert.assertTrue(flag, "WebSite has not navigated to second Page");	
		test.log(LogStatus.PASS, "Website is navigated towards the second page");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Website is not navigated towards the second page");
		}
		extent.endTest(test);
	    extent.flush();
	}
	//**************************** Third Page Navigation and Verification ***********************************//
	@Test(priority=3,dependsOnMethods="secondPageTest",groups={"regression","smoke"})
	public void thirdPageTest()
	{
		test = extent.startTest("Verify Third Page");
		test.log(LogStatus.INFO, "Verifying Third Page");
		setSearchType set = new setSearchType();
		set.searchType(driver);
		test.log(LogStatus.INFO, "Search Type has been entered");
		checkPages thirdPage = new checkPages();
		boolean flag=thirdPage.checkThirdPage(driver);
		try
		{
		Assert.assertTrue(flag, "Web Site has not navigated to third Page");
		test.log(LogStatus.PASS, "Website is navigated towards the third page");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Website is not navigated towards the third page");
		}
		extent.endTest(test);
	    extent.flush();
		
	}
	
	//***********SETTING CHECKIN DATE**********************************//	
	@Test(priority=4,dependsOnMethods="thirdPageTest",groups="regression")
	public void setCheckinDateTest() throws InterruptedException, ParseException
	{
		test = extent.startTest("Checkin Date verification");
		test.log(LogStatus.INFO, "Providing Check-in Date");
		DatePicker date = new DatePicker();
		date.setCheckinDate(driver);
		try
		{
		Assert.assertTrue(checkDates.checkDatein(driver),"Check-in Date isn't set properly");
		test.log(LogStatus.PASS, "Checkin date has been set successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Checkin date has not been set successfully");
		}
		extent.endTest(test);
	    extent.flush();
	}
	@Test(priority=5,dependsOnMethods="setCheckinDateTest",groups="regression")
	public void setCheckoutDateTest() throws InterruptedException, ParseException
	{
		test = extent.startTest("Checkout Date verification");
		test.log(LogStatus.INFO, "Providing Check-out Date");
		DatePicker date = new DatePicker();
		date.setCheckoutDate(driver);
		try
		{
		Assert.assertTrue(checkDates.checkDateout(driver),"Check-out Date isn't set properly");
		test.log(LogStatus.PASS, "Checkout date has been set successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Checkout date has not been set successfully");
		}
		extent.endTest(test);
	    extent.flush();
	}
	@Test(priority=6,dependsOnMethods="setCheckoutDateTest",groups="regression")
	public void updateTest()
	{
		test = extent.startTest("Update filters");
		test.log(LogStatus.INFO, "Clicking on upodate button");
		Update.updateFilter(driver);
		test.log(LogStatus.PASS, "Update has been done successfully");
		extent.endTest(test);
	    extent.flush();
	}
	@Test(priority=7,dependsOnMethods="setCheckoutDateTest",groups="regression")
	public void setLowestPriceSliderTest()
	{
		test = extent.startTest("Verifying Lowest Price");
		test.log(LogStatus.INFO, "Adjusting lowest price slider");
		setPriceSliders price = new setPriceSliders();
		price.setLowerPriceSlider(driver);
		try
		{
		Assert.assertTrue(checkPrice.checkLowestPrice(driver), "Lowest price isn't set properly");
		test.log(LogStatus.PASS, "Lowest Price has been set sucessfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Lowest Price has not been set sucessfully");
		}
		extent.endTest(test);
	    extent.flush();
	}
	@Test(priority=8,dependsOnMethods="setLowestPriceSliderTest",groups="regression")
	public void setHighestPriceSliderTest() throws InterruptedException
	{
		test = extent.startTest("Verifying highest Price");
		test.log(LogStatus.INFO, "Adjusting highest price slider");
		setPriceSliders price = new setPriceSliders();
		price.setUpperPriceSlider(driver);
		try
		{
		Assert.assertTrue(checkPrice.checkHighestPrice(driver),"Highest price isn't set properly");	
		test.log(LogStatus.PASS, "Highest Price has been set sucessfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Highest Price has not been set sucessfully");
		}
		extent.endTest(test);
	    extent.flush();
	}
	@Test(priority=9,dependsOnMethods="setHighestPriceSliderTest",groups="regression")
	public void getSearchResultsTest() throws InterruptedException
	{
		test = extent.startTest("Search Result extraction");
		test.log(LogStatus.INFO, "obtaining search results");
		test.log(LogStatus.INFO, "Writing the results in Excel sheet");
		ExcelWriter.getSearchResults(driver);
		test.log(LogStatus.PASS, "Excel writing has been done successfully");
		extent.endTest(test);
	    extent.flush();
		
	}
	@AfterTest
	public void tearDown()
	{
		test = extent.startTest("Close test");
		test.log(LogStatus.INFO, "closing the browser");
		driver.quit();
		test.log(LogStatus.PASS, "Browser is closed successfully");
		extent.endTest(test);
	    extent.flush();
	}
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avina\\chromedriver\\chromedriver_v84.exe");
//	    WebDriver  driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.tripadvisor.in/");
//		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//		WebElement search = driver.findElement(By.xpath("(//input[@class='_3qLQ-U8m' and @title='Search'])[2]"));
//		search.sendKeys("Mumbai");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement mumbai = driver.findElement(By.xpath("//a[@title='Mumbai']"));
//		WebDriverWait wait3 = new WebDriverWait(driver,30);
//		wait3.until(ExpectedConditions.visibilityOf(mumbai)); 
//		wait3.until(ExpectedConditions.elementToBeClickable(mumbai));
//		mumbai.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebElement hotels = driver.findElement(By.cssSelector("#lithium-root > main > div._1brQmsfe > div > div > div:nth-child(1) > a"));
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(hotels)); 
//		wait.until(ExpectedConditions.elementToBeClickable(hotels));
//		hotels.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String m1 = driver.findElement(By.xpath("(//div[@class='_1JMy14it']/div)[1]")).getText();
//		String m2 = driver.findElement(By.xpath("(//div[@class='_1JMy14it']/div)[2]")).getText();
//		String checkinDate = "13 August 2020";
//		String[] inDate = checkinDate.split(" ");
//		String checkOutDate= "2 September 2020";
//		String[] outDate = checkOutDate.split(" ");
////		while(m1.equals("September 2020") || m2.equals("September 2020"))
////		{
////			driver.findElement(By.xpath("//button[@class='ui_icon single-chevron-right _2PvL_zPQ _3sCfCRAV']")).click();
////		}
//		if(m1.equals(inDate[1]+" "+inDate[2]))
//		{
//			WebElement t1 = driver.findElement(By.xpath("(//div[@class='_3d8K7K3- notranslate'])[1]"));
//			List<WebElement> list1 = t1.findElements(By.tagName("div"));
//			for (WebElement cell : list1) {
//	        	if (cell.getText().equals(inDate[0])) {
//	                cell.click();
//	                Thread.sleep(3000);
//	                break;
//	            }
//		}
//		}
//		else if(m2.equals(inDate[1]+" "+inDate[2]))
//		{
//			WebElement t2 = driver.findElement(By.xpath("(//div[@class='_3d8K7K3- notranslate'])[2]"));
//			List<WebElement> list2 = t2.findElements(By.tagName("div"));
//			for (WebElement cell : list2) {
//	        	if (cell.getText().equals(inDate[0])) {
//	                cell.click();
//	                Thread.sleep(3000);
//	                break;
//	            }
//		}
//		}
//		 Thread.sleep(3000);
//		if(m1.equals(outDate[1]+" "+outDate[2]))
//		{
//			WebElement t1 = driver.findElement(By.xpath("(//div[@class='_3d8K7K3- notranslate'])[1]"));
//			List<WebElement> list1 = t1.findElements(By.tagName("div"));
//			for (WebElement cell : list1) {
//	        	if (cell.getText().equals(outDate[0])) {
//	                cell.click();
//	                Thread.sleep(3000);
//	                break;
//	            }
//		}
//		}
//		else if(m2.equals(outDate[1]+" "+outDate[2]))
//		{
//			WebElement t2 = driver.findElement(By.xpath("(//div[@class='_3d8K7K3- notranslate'])[2]"));
//			List<WebElement> list2 = t2.findElements(By.tagName("div"));
//			for (WebElement cell : list2) {
//	        	if (cell.getText().equals(outDate[0])) {
//	                cell.click();
//	                Thread.sleep(3000);
//	                break;
//	            }
//		}
//		}
//		driver.findElement(By.xpath("//button[@class='ui_button primary fullwidth']")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,225)");
//		WebElement lslider = driver.findElement(By.xpath("(//div[@class='_18B1YU3u _3Hwhseze'])[1]"));
//		WebDriverWait wait2 = new WebDriverWait(driver,30);
//		wait2.until(ExpectedConditions.visibilityOf(lslider)); 
//		wait2.until(ExpectedConditions.elementToBeClickable(lslider));
//		Dimension ldim = lslider.getSize();
//		int x = ldim.getWidth();
//		Actions action = new Actions(driver);
//		action.clickAndHold(lslider).moveByOffset(x-6,0).release().perform();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Thread.sleep(3000);
//		Actions actions = new Actions(driver);
//    	WebElement rslider = driver.findElement(By.xpath("//*[@id=\"component_10\"]/div/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[3]"));
//    	WebDriverWait wait1 = new WebDriverWait(driver, 40);
//		wait1.until(ExpectedConditions.visibilityOf(rslider)); 
//		wait1.until(ExpectedConditions.elementToBeClickable(rslider));
//    	actions.click(rslider).build().perform();
//    	Thread.sleep(1000);
//     	Dimension rdim = rslider.getSize();
//    	int y = rdim.getWidth();
//    	actions.dragAndDropBy(rslider, -162, 0).click().build().perform();
//    	//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//    	Thread.sleep(7000);
//    	System.out.println(driver.findElement(By.xpath("//span[@class='_3nOjB60a']")).getText());
//
//	}

}
