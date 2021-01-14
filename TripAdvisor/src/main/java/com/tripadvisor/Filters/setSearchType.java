package com.tripadvisor.Filters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class setSearchType extends tripAdvisorPOF {
	
	public void searchType(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement hotels = driver.findElement(Hotels);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(hotels)); 
		wait.until(ExpectedConditions.elementToBeClickable(hotels));
		hotels.click();
	}	

}
