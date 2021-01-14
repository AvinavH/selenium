package com.cleartrip.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNG extends driverSetup
{
	
	@BeforeMethod
	public void test1()
	{
		driver = setup();
	}
	
	
@Test(priority=1)	
public void searching() throws Exception
{
	driver.findElement(By.xpath("//*[@id='RoundTrip']")).click();
	WebElement we = driver.findElement(By.xpath("(//*[@title='Any worldwide city or airport'])[1]"));
	we.sendKeys(Write.getvalue1());
	we.sendKeys(Keys.ENTER);
	
	
	WebElement wc= driver.findElement(By.xpath("(//*[@title='Any worldwide city or airport'])[2]"));

	wc.sendKeys(Write.getvalue2());
	wc.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@title=\"Depart date\"]")).click();
	driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@title=\"Return date\"]")).click();
	driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[4]")).click();
	Thread.sleep(2000);
	
	Select sc = new Select(driver.findElement(By.xpath("//*[@id='Adults']")));
	sc.selectByIndex(4);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();
	
	Thread.sleep(25000);
	
	Screenshots.captureScreenshot(driver, "FlightDetails");
	
	}
  @AfterMethod
  public void exit()
  {
	quit();  
  }
  
  }