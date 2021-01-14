package com.cleartrip.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreen {
public static void Screenshot(WebDriver driver) throws IOException {      // capturing screenshot
		
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File f1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File(System.getProperty("user.dir")+"/screenshot/"+timestamp+"_ClearTrip.png"));
		
	}
	

}
