package com.course.Util;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.course.Pages.SecondPage;


public class captureScreen extends SecondPage {

  public captureScreen()
  {
	  super();
  }

 public void ScreenShot() throws IOException
 {
 JavascriptExecutor js = (JavascriptExecutor) driver ;
 js.executeScript("arguments[0].scrollIntoView(false);", Rating2); // Scroll up to the Second Course is visible
 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 TakesScreenshot scrst = (TakesScreenshot) driver;
 File CaptureImg = scrst.getScreenshotAs(OutputType.FILE);
 FileUtils.copyFile(CaptureImg,new File("C:\\Users\\avina\\eclipse-workspace\\Course\\test-output\\ScreenShots\\"+timestamp+"_output.png"));
 }
 
 public static String screenCapture(String NegativeScreenshot) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 //String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = "C:\\Users\\avina\\eclipse-workspace\\Course\\test-output\\ErrorScreenshots\\"+NegativeScreenshot+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	        
	        return dest;
	}

}
