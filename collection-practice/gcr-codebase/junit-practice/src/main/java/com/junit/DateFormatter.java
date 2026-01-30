package com.junit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
	
	public String formatDate(String inputDate) {
		
		// Input format (example: yyyy-MM-dd)
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		// Output format (example: dd-MM-yyyy)
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		// Convert String → LocalDate
		LocalDate date = LocalDate.parse(inputDate, inputFormatter);
		
		// Convert LocalDate → formatted String
		return date.format(outputFormatter);
	}
}
