package com.junit;

import java.util.regex.*;

public class PasswordValidator {
	
	public boolean checkPassword(String password) {
		String regex = "[a-zA-Z0-9]{8,}";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		
		if(m.matches()) {
			return true;
		}
		return false;
	}
}
