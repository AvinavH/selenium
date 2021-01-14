package com.emi_calculator_grid.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_xlsx {
	Properties property;
	
	public Row input_file() throws IOException {
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		property = new Properties();
		property.load(fs);
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+property.getProperty("Xlsx_File_location"));
		Workbook wrk = new XSSFWorkbook(stream);
		Sheet shit=wrk.getSheetAt(0);
		Row row=shit.getRow(1);
		return row;
		
	}
	
	
	public String input_loan_amount(Row row) throws IOException
	{
		String Amount=row.getCell(0).getStringCellValue();
		return Amount;
		
	}
	
	public String input_loan_interest(Row row) throws IOException
	{
		String Interest=row.getCell(1).getStringCellValue();
		return Interest;
		
	}
	
	public String input_loan_tennure(Row row) throws IOException
	{
		String Tennure=row.getCell(2).getStringCellValue();
		return Tennure;
	}
	

}
