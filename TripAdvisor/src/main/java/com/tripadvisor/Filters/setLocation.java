package com.tripadvisor.Filters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class setLocation extends tripAdvisorPOF {
	
	public void location(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement search = driver.findElement(searchDestination);
		search.sendKeys("Mumbai");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement mumbai = driver.findElement(city);
		WebDriverWait wait3 = new WebDriverWait(driver,50);
		wait3.until(ExpectedConditions.visibilityOf(mumbai)); 
		wait3.until(ExpectedConditions.elementToBeClickable(mumbai));
		mumbai.click();
	}

}
