package com.course.Util;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	 public static WebDriver driver;
	 public static String HubUrl="http://192.168.42.1:4444/wd/hub";

	 public static WebDriver getDriver(String browser,String mode) throws IOException
		{
			// Driver SetUp for Grid		
			if(mode.equalsIgnoreCase("grid"))
			{
				if(browser.equalsIgnoreCase("Chrome"))
				{
					DesiredCapabilities cap= DesiredCapabilities.chrome();
					cap.setBrowserName("chrome");
					cap.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(HubUrl),cap);
					driver.manage().window().maximize();
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
						DesiredCapabilities cap= DesiredCapabilities.firefox();
						cap.setBrowserName("firefox");
						cap.setPlatform(Platform.WINDOWS);
						driver = new RemoteWebDriver(new URL(HubUrl),cap);
				}
				else if(browser.equalsIgnoreCase("InternetExplorer"))
				{
					DesiredCapabilities cap= DesiredCapabilities.internetExplorer();
					driver = new RemoteWebDriver(new URL(HubUrl),cap);	
				}
				
			}
			// Driver SetUp for Local
			else if(mode.equalsIgnoreCase("local"))
			{
				if(browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\avina\\chromedriver\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();  
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver","C:\\Users\\avina\\geckodriver\\geckodriver.exe" );  
					FirefoxOptions options = new FirefoxOptions();  
					options.setLegacy(true);
				    driver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("InternetExplorer"))
				{
					System.setProperty("webdriver.ie.driver", "C:\\Users\\avina\\IEDriverServer\\IEDriverServer32.exe");
					InternetExplorerOptions options = new InternetExplorerOptions();
					options.enableNativeEvents();
					options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					options.ignoreZoomSettings();
					options.introduceFlakinessByIgnoringSecurityDomains();
					options.requireWindowFocus();
					driver = new InternetExplorerDriver(options);
					driver.manage().window().maximize();
				}
				
				
			}
			return driver;
		}


}
