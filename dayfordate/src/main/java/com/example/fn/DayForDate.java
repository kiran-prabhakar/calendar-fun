package com.example.fn;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.lang.Exception;

import com.fnproject.fn.api.Headers;
import com.fnproject.fn.api.InvocationContext;
import com.fnproject.fn.api.QueryParameters;
import com.fnproject.fn.api.httpgateway.HTTPGatewayContext;

public class DayForDate {

   public String handleRequest(HTTPGatewayContext context, String input) {

	try {
	String dateStr =  context.getQueryParameters().get("date").get();
	if(dateStr == null ) return "{ \"Day\" : \"No Date Specified\" }";
 
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
	Calendar iCal = Calendar.getInstance();
	//iCal.setTime(dateFormatter.parse(input));
 	iCal.setTime(dateFormatter.parse(dateStr));
	int weekday = iCal.get(Calendar.DAY_OF_WEEK);
	DateFormatSymbols formatSym = new DateFormatSymbols();
	StringBuilder sb = new StringBuilder("{ \"Day\" : \""  + formatSym.getWeekdays()[weekday] + "\"}");

	return sb.toString();
	}
	catch(Exception e) {
	 return (e.toString());
	}	
    }

}
