package com.salesForce.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver_setup {

	
public static WebDriver driver;
	
	public static WebDriver getDriver(String browser)
	{
		String fileName = "chromedriver.exe";
		String fileName2 = "geckodriver.exe";
	    String path = System.getProperty("user.dir");
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", path+"\\Driver\\"+fileName);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", path+"\\Driver\\"+fileName2);
			FirefoxOptions options = new FirefoxOptions();  
			options.setLegacy(true);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
	}
	
}
