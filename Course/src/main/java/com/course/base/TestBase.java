package com.course.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.course.Util.DriverSetup;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		FileInputStream readFile= null;
		try
		{
			prop = new Properties();
			readFile = new FileInputStream("C:\\Users\\avina\\eclipse-workspace\\Course\\src\\main\\java\\com\\course\\config\\Config.properties");
			prop.load(readFile);
		}
		catch(IOException io) {
			io.printStackTrace();
		}

}
	public static void initialization() throws IOException
	{
		String browser= prop.getProperty("Browser");
		String mode = prop.getProperty("mode");
		System.out.println("Mode selected : "+mode);
		System.out.println("Browser selected: "+browser);
		driver=DriverSetup.getDriver(browser, mode);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		}
		

}
