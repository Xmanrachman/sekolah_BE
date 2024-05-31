/**
 * 
 */
package com.managemen.sekolah.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


/**
 * 
 */
public class DateUtil {
	
	
	public static Date convertStringToDate(String date, String dateFormat) {
		if (date == null)
			return null;

		final String dateTrim = date.trim();
		
		if (dateTrim.length() == 0)
			return null;

		final SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		Date result = null;
		
		try {
			result = df.parse(dateTrim);
			
		} catch (ParseException x) {
		}
		
		return result;
	}
	
	
	public static Date convertDateToDate(Date date, String dateFormat) {
		if (date == null)
			return null;

		final SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		Date result = null;

		try {
			result = df.parse(df.format(date));
		} catch (ParseException x) {
		}

		return result;
	}
	

}
