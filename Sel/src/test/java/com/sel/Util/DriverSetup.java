package com.sel.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
	
	public static void main(String[] args)
	{
		String fileName = "chromedriver.exe";
	    String path = System.getProperty("user.dir");
	    System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"\\"+fileName);
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();  
		//options.addArguments("incognito");
		options.addArguments("start-maximized"); 
		options.addArguments("disable-infobars");
		ChromeDriver driver = new ChromeDriver(options); 
		driver.get("https:\\www.cleartrip.com");
		driver.close();
	}

}
