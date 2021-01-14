package com.cleartrip.flights;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write
{
 public static String Value1;
 public static String Value2;
 public static String getvalue1() throws Exception
 {
 FileInputStream fi = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\com.cleartrip.flights\\Excel1.xlsx");
 XSSFWorkbook wb = new XSSFWorkbook(fi);
 XSSFSheet sh = wb.getSheet("Sheet1");
 Value1 = sh.getRow(0).getCell(0).getStringCellValue();
 return Value1;
 }
 public static String getvalue2() throws Exception
 {
  
 FileInputStream fi = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\com.cleartrip.flights\\Excel1.xlsx");
 XSSFWorkbook wb = new XSSFWorkbook(fi);
 XSSFSheet sh = wb.getSheet("Sheet1");
 Value2 = sh.getRow(0).getCell(1).getStringCellValue();
 return Value2;
 }
}