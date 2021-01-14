package com.salesForce.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_xlsx {
	Properties property;
	
	public static Row input_file() throws IOException {
		
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\"+"salesForce_Data.xlsx");
		Workbook wrk = new XSSFWorkbook(stream);
		Sheet shit=wrk.getSheetAt(0);
		Row row=shit.getRow(1);
		return row;
		
	}
	
	
	public static String input_emailid(Row row) throws IOException
	{
		String Emaild=row.getCell(0).getStringCellValue();
		return Emaild;
		
	}
	
	public static String input_Country(Row row) throws IOException
	{
		String Country=row.getCell(1).getStringCellValue();
		return Country;
		
	}
	
	
	

}
