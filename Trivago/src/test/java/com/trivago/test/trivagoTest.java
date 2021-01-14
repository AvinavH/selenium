package com.trivago.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class trivagoTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\avina\\chromedriver\\chromedriver_v84.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.trivago.in");
	}
	@Test
	public void TrivagoTest()
	{
    	WebElement search = driver.findElement(By.xpath("//input[@id='querytext']")); 
    	search.sendKeys("Mumbai");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     	search.sendKeys(Keys.ENTER);
     	String month = driver.findElement(By.xpath("//*[@id='cal-heading-month']/span")).getText();
     	String date = "2020-09-03";
     	boolean flag=false;
    	while(month.equals("September 2020"))
    	{
     		driver.findElement(By.xpath("//button[@class='cal-btn-next']")).click();
     	}
     	for(int i=1;i<=7;i++)
     	{
     		for(int j=1;j<=7;j++)
     		{
     			if(date.equals(driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div[4]/div[2]/div/table/tbody/tr['+i+']/td['+j+']/time")).getAttribute("datetime")))
     			{
     				driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div[4]/div[2]/div/table/tbody/tr['+i+']/td['+j+']/time")).click();
     				flag=true;
     				break;
     			}
     		}
     		if(flag)
     		{
     			break;
     		}
     	}
	}
	//*[@id="js-fullscreen-hero"]/div[1]/form/div[4]/div[2]/div/table/tbody/tr[1]/td[4]
	//*[@id="js-fullscreen-hero"]/div[1]/form/div[4]/div[2]/div/table/tbody/tr[1]/td[5]
	//*[@id="js-fullscreen-hero"]/div[1]/form/div[4]/div[2]/div/table/tbody/tr[2]/td[1]/time
	
}
