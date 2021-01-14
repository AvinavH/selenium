package com.cleartrip.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsx {     
	
	
	public static String input_source() throws IOException    // read source data from excel file
	{
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\cleartrip.xlsx");
		Workbook wrk = new XSSFWorkbook(stream);
		Sheet sheet=wrk.getSheetAt(0);
		Row row=sheet.getRow(1);
		String Source=row.getCell(0).getStringCellValue();
		return Source;
		
	}
	
	public static String input_dest() throws IOException   // read destination data from excel file
	{
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\cleartrip.xlsx");
		Workbook wrk = new XSSFWorkbook(stream);
		Sheet sheet=wrk.getSheetAt(0);
		Row row=sheet.getRow(1);
		String dest=row.getCell(1).getStringCellValue();
		return dest;
		
	}
	

}
