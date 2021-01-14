package com.cleartrip.flights;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class driverSetup 
{
 WebDriver driver;
   public WebDriver setup()
   {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\eclipse-workspace\\com.cleartrip.flights\\drivers\\chromedriver.exe");
  WebDriver driver = new ChromeDriver();
  String url = "https://www.cleartrip.com/";
  driver.navigate().to(url);
  driver.manage().window().maximize();
  return driver;
   
   }
   public void quit()
   {
    driver.quit();
   
   }
}
