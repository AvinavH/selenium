package com.course.Util;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.course.Pages.SecondPage;

public class ExcelWriter extends SecondPage {

	public ExcelWriter()
	{
		super();
	}
 XSSFWorkbook wb = null;
 XSSFSheet sh = null;

 public void courseInfo1()throws FileNotFoundException, IOException {

	 String name1 = CourseName1.getText(); // First Course Name locator
	 System.out.println(name1);
	 String rating1 = Rating1.getText(); // First Course Rating Locator
	 System.out.println(rating1);
	 String duration1 = Hours1.getText(); // First Course Duration Locator
	 System.out.println(duration1);
	 File file = new File("C:\\Users\\avina\\eclipse-workspace\\Course\\test-output\\CourseraOutput.xlsx");
	 try
	 	{

		 	FileInputStream fis = new FileInputStream(file);
		 	wb = new XSSFWorkbook(fis);
		 	sh = wb.getSheetAt(0);
		 	sh.createRow(1).createCell(0).setCellValue(name1);
		 	sh.getRow(1).createCell(1).setCellValue(rating1);
		 	sh.getRow(1).createCell(2).setCellValue(duration1);
		 	FileOutputStream outputStream = new FileOutputStream(file);
		 	wb.write(outputStream);
	 	}

	 catch(Exception e)
	 	{
		 	e.printStackTrace();

	 	}

 	}


 public void courseInfo2() throws IOException

 {
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 String name2 = CourseName2.getText(); // Second Course Name Locator
	 System.out.println(name2);
	 String rating2 = Rating2.getText(); // Second Course Rating Locator
	 System.out.println(rating2);
	 String duration2= Hours2.getText(); // Second Course Duration Locator
	 System.out.println(duration2);
	 File file = new File("C:\\Users\\avina\\eclipse-workspace\\Course\\test-output\\CourseraOutput.xlsx");
	 try
	 	{

		 	FileInputStream fis = new FileInputStream(file);
		 	wb = new XSSFWorkbook(fis);
		 	sh = wb.getSheetAt(0);
		 	sh.createRow(2).createCell(0).setCellValue(name2);
		 	sh.getRow(2).createCell(1).setCellValue(rating2);
		 	sh.getRow(2).createCell(2).setCellValue(duration2);
		 	FileOutputStream outputStream = new FileOutputStream(file);
		 	wb.write(outputStream);
		}

 catch(Exception e)
	 	{
	 	e.printStackTrace();
	 	}



 }



}

