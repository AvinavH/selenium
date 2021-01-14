package com.cleartrip.base;

import org.openqa.selenium.WebDriver;

import com.cleartrip.util.DriverSetup;



public class BasePage {       
public static WebDriver driver;
	
	public static WebDriver launchUrl(String browser, String url)
	{
		driver = DriverSetup.getDriver(browser);        //initializing the browser
		driver.get(url);                               //launch URL
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.quit();                             //closing the browser
	}
	


}
