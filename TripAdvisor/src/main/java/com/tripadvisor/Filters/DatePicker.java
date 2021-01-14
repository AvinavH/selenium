package com.tripadvisor.Filters;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;
import com.tripadvisor.Utility.getDates;

public class DatePicker extends tripAdvisorPOF {
	
	public void setCheckinDate(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement prev = driver.findElement(navigationPrev);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;",prev);
		driver.findElement(navigationPrev).click();
		String checkInDate = getDates.getCheckInDate(); 
		String m1 = driver.findElement(monthName1).getText();
		String m2 = driver.findElement(monthName2).getText();
		String[] inDate = checkInDate.split(" ");
		if(m1.equals(inDate[1]+" "+inDate[2]))
		{
			WebElement t1 = driver.findElement(dateGrid1);
			List<WebElement> list1 = t1.findElements(By.tagName("div"));
			for (WebElement cell : list1) {
	        	if (cell.getText().equals(inDate[0])) {
	                cell.click();
	                Thread.sleep(3000);
	                break;
	            }
		}
		}
		else if(m2.equals(inDate[1]+" "+inDate[2]))
		{
			WebElement t2 = driver.findElement(dateGrid2);
			List<WebElement> list2 = t2.findElements(By.tagName("div"));
			for (WebElement cell : list2) {
	        	if (cell.getText().equals(inDate[0])) {
	                cell.click();
	                Thread.sleep(3000);
	                break;
	            }
		}
		}
	}
	public void setCheckoutDate(WebDriver driver) throws InterruptedException
	{
		//driver.findElement(By.xpath("//button[@class='ui_icon single-chevron-left _2PvL_zPQ _3QXSl3nP' and @data-testid=\"nav_prev\"]")).click();
		String m1 = driver.findElement(monthName1).getText();
		String m2 = driver.findElement(monthName2).getText();
		String checkOutDate= getDates.getCheckOutDate();
		String[] outDate = checkOutDate.split(" ");
		Thread.sleep(3000);
		if(m1.equals(outDate[1]+" "+outDate[2]))
		{
			WebElement t1 = driver.findElement(dateGrid1);
			List<WebElement> list1 = t1.findElements(By.tagName("div"));
			for (WebElement cell : list1) {
	        	if (cell.getText().equals(outDate[0])) {
	                cell.click();
	                Thread.sleep(3000);
	                break;
	            }
		}
		}
		else if(m2.equals(outDate[1]+" "+outDate[2]))
		{
			WebElement t2 = driver.findElement(dateGrid2);
			List<WebElement> list2 = t2.findElements(By.tagName("div"));
			for (WebElement cell : list2) {
	        	if (cell.getText().equals(outDate[0])) {
	                cell.click();
	                Thread.sleep(3000);
	                break;
	            }
		}
		}
	}

}
