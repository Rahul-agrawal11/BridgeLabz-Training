package com.employeewage.util;

import java.util.regex.Pattern;

public class RegexValidator {
	private static final String COMPANY_NAME_REGEX = "^[A-Z][a-zA-Z0-9]{2,20}$";
	private static final Pattern COMPANY_PATTERN = Pattern.compile(COMPANY_NAME_REGEX);
	
	public static boolean isValidComapnyName(String companyName) {
		return companyName != null && COMPANY_PATTERN.matcher(companyName).matches();
	}

}
