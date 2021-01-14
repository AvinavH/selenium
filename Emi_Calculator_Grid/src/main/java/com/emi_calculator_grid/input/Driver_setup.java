package com.emi_calculator_grid.input;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver_setup {
	
	static WebDriver driver;
    public WebDriver getChromeDriver() throws IOException {
    	
    	String nodeurl_forChrome="http://192.168.0.103:4444/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		
		driver=new RemoteWebDriver(new URL(nodeurl_forChrome),cap);
		return driver;
    	
    }
    
    public WebDriver getFirefoxDriver() throws IOException
    {
    	String nodeurl_forFirefox="http://192.168.0.103:4444/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL(nodeurl_forFirefox),cap);
		return driver;
    	
    }

}
