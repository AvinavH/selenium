package com.tripadvisor.Filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;
import com.tripadvisor.Utility.getDates;

public class checkDates extends tripAdvisorPOF {
	
	public static boolean checkDatein(WebDriver driver) throws ParseException
	{
		String checkInDt= getDates.getCheckInDate();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy",Locale.ENGLISH);
		Date dt =sdf.parse(checkInDt);
		String Dt = driver.findElement(checkin).getText();
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, dd/MM/yy",Locale.ENGLISH);
		Date indate = sdf1.parse(Dt);
		if(indate.compareTo(dt)==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public static boolean checkDateout(WebDriver driver) throws ParseException
	{
		String checkOutDt=getDates.getCheckOutDate();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy",Locale.ENGLISH);
		Date dt =sdf.parse(checkOutDt);
		String Dt = driver.findElement(checkout).getText();
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, dd/MM/yy",Locale.ENGLISH);
		Date outdate = sdf1.parse(Dt);
		if(outdate.compareTo(dt)==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
