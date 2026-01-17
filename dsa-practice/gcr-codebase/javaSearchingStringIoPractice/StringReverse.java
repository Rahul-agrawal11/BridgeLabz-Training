package javaSearchingStringIoPractice;

import java.util.Scanner;

public class StringReverse {
	
	
	// Method to reverse a string
	public static String reverseString(String text) {
		
		// Convert String into StringBuilder
		StringBuilder sb = new StringBuilder(text);
		
		// Reverse the string 
		sb.reverse();
		
		// Return the string builder by converting in string
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enetr text for reverse: ");
		String text = input.nextLine();
		
		// String to store reverse value of string through method call
		String revStr = StringReverse.reverseString(text);
		
		// Display the reverse of the string
		System.out.println("Reverse of string is: " + revStr);
		
		input.close();
	}
}
