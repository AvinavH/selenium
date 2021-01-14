package com.emi_calculator_grid.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_xlsx {
	
	Properties property;

	
	public void write_interestAmmout(String str) throws IOException {
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		property = new Properties();
		property.load(fs);
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+property.getProperty("Xlsx_File_location"));
		Workbook wrk = new XSSFWorkbook(stream);
		Sheet shit=wrk.getSheetAt(0);
		Row row=shit.getRow(1);
		row.createCell(4).setCellValue(str);
		FileOutputStream stream1 = new FileOutputStream(System.getProperty("user.dir")+property.getProperty("Xlsx_File_location"));
		wrk.write(stream1);
	}
	
	public void write_principleAmmout(String str) throws IOException {
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		property = new Properties();
		property.load(fs);
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+property.getProperty("Xlsx_File_location"));
		Workbook wrk = new XSSFWorkbook(stream);
		Sheet shit=wrk.getSheetAt(0);
		Row row=shit.getRow(1);
		row.createCell(5).setCellValue(str);
		FileOutputStream stream1 = new FileOutputStream(System.getProperty("user.dir")+property.getProperty("Xlsx_File_location"));
		wrk.write(stream1);
	}
}
