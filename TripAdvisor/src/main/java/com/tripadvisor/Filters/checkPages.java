package com.tripadvisor.Filters;

import org.openqa.selenium.WebDriver;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class checkPages extends tripAdvisorPOF  {
	public boolean checkHome(WebDriver driver)
	{
		String actual = driver.getTitle();
		String expected = "Tripadvisor Official Site";
		if(actual.contains(expected))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean checkSecondPage(WebDriver driver)
	{
		String loc = driver.findElement(destination).getText();
		if(loc.equals("Explore Mumbai"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkThirdPage(WebDriver driver)
	{
		String actual = driver.getTitle();
		String expected = "The 10 Best Hotels in Mumbai 2020 (with Prices) - Tripadvisor";
		if(actual.equals(expected))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
