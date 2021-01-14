package com.tripadvisor.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class ExcelWriter extends tripAdvisorPOF {
	
	 static XSSFWorkbook wb = null;
	 static XSSFSheet sh = null;
	public static void getSearchResults(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(7000);
		String no = driver.findElement(searchResults).getText();
		String[] noOfSearchResults = no.split(" ");
		System.out.println(noOfSearchResults[0]);
		File file = new File("C:\\Users\\avina\\eclipse-workspace\\TripAdvisor\\TripAdvisorOutput.xlsx");
		try
		{
			FileInputStream fis = new FileInputStream(file);
			 wb = new XSSFWorkbook(fis);
			 sh = wb.getSheetAt(0);
			 sh.createRow(1).createCell(0).setCellValue(noOfSearchResults[0]);
			 FileOutputStream outputStream = new FileOutputStream(file);
             wb.write(outputStream);
		}
		catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}

}
