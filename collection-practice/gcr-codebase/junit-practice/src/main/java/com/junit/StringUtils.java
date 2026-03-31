package com.junit;

public class StringUtils {
	
	public String reverse(String str) {
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			revStr += str.charAt(i);
		}
		return revStr;
	}
	
	public boolean isPalindrome(String str) {
		if(str.equals(reverse(str))) {
			return true;
		}
		return false;
	}
	
	public String convertUpperCase(String str) {
		return str.toUpperCase();
	}
}
