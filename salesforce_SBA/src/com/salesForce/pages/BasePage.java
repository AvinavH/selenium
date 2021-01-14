package com.salesForce.pages;

import org.openqa.selenium.WebDriver;

import com.salesForce.util.Driver_setup;

public class BasePage {
	
public static WebDriver driver;
	
	public static WebDriver launchUrl(String browser, String url)
	{
		driver = Driver_setup.getDriver(browser); //initializing the browser
		driver.get(url); //launch url
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.quit(); //closing the browser
	}
	

}
