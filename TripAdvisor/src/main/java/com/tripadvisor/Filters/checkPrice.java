package com.tripadvisor.Filters;

import org.openqa.selenium.WebDriver;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class checkPrice extends tripAdvisorPOF {
	
	public static boolean checkLowestPrice(WebDriver driver)
	{
		String slider = driver.findElement(sliderValues).getText();
		slider.trim();
    	String LowerLimit = slider.substring(slider.indexOf(' '),slider.indexOf('-')).trim();
		if(LowerLimit.contains("2,"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkHighestPrice(WebDriver driver)
	{
		String slider = driver.findElement(sliderValues).getText();
		slider.trim();
    	String upperLimit = slider.substring(slider.lastIndexOf(' ')).trim();
		if(upperLimit.contains("3,"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
