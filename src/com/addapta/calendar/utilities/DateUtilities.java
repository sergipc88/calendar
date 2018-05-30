package com.addapta.calendar.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {
	
	public static Date dateParser(String f) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(f);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	
public static Date dateParser2(String f) {
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		try {
//			date = formatter.parse(f);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	   SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
	   SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
	   Date date = null;
	   try {
	     date = originalFormat.parse(f);
	     System.out.println("Old Format :   " + originalFormat.format(date));
	     System.out.println("New Format :   " + targetFormat.format(date));

	    } catch (ParseException ex) {
	      // Handle Exception.
	    }
		
		return date;
	}
	
	
	public static Date hourParser(String h) {
		
		Date date = null;
		
		DateFormat hour = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
			try {
				date = formateador.parse(h);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
		return date;
	}

public static Date hourParser2(String h) {
		
		Date date = null;
		
		DateFormat hour = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
			try {
				date = formateador.parse(h+":00");
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
		return date;
	}

	public static Date joinDateHour(Date day, Date hour) {
		Date joined = null;
	
		SimpleDateFormat fechaHora= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   
			try {
				joined = fechaHora.parse(day+" "+hour);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    
		return joined;
	}
	
	
	public static String joinDH(Date day, Date hour) {
	
	

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
		// Get the date today using Calendar object.
	      
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(day);
		String reportHour = df2.format(hour);
		// Print what date is today!
		System.out.println("Report Date: " + reportDate+" "+reportHour);
		String dh = reportDate +"T"+ reportHour;
		return dh;
	}

}
