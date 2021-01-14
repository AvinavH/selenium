package com.course.Util;

import java.util.Calendar;
import java.util.Date;

import com.course.Pages.SecondPage;

public class Time extends SecondPage {
	
	public static Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
