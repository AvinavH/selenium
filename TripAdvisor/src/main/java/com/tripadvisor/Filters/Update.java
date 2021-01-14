package com.tripadvisor.Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class Update extends tripAdvisorPOF {
	public static void updateFilter(WebDriver driver)
	{
		driver.findElement(update).click();
	}

}
