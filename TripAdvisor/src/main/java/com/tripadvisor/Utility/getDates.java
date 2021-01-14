package com.tripadvisor.Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getDates {
	
	public static String getCheckInDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("d MMMMMMMMM yyyy");
		Calendar cal = Calendar.getInstance();  //Getting current date
		cal.add(Calendar.DAY_OF_MONTH, 7); 
		String checkinDate = sdf.format(cal.getTime()); 
		return checkinDate;
	}
	public static String getCheckOutDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("d MMMMMMMMM yyyy");
		Calendar cal = Calendar.getInstance();  //Getting current date
		cal.add(Calendar.DAY_OF_MONTH, 9); 
		String checkoutDate = sdf.format(cal.getTime()); 
		return checkoutDate;
	}

}
