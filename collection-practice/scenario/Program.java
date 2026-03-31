package scenario;

import java.util.Scanner;
import java.util.regex.*;

public class Program {
	
	// Method to genrate key 
	public String CleanseAndInvert(String word) {
		Program p = new Program();
		word = p.checkInput(word);
		
		// Return empty string if word is empty or null
		if (word.isEmpty()) {
			return "";
		}
		
		// Convert string into lowercase then reverse it
		StringBuilder key = new StringBuilder(word.toLowerCase()).reverse();
		String generateKey = "";
		int pointer = 0;
		
		for (int i = 0; i < key.length(); i++) {
			
			// Check for Even ASCII value of character
			if (key.charAt(i) % 2 != 0) {
				
				// Check for even index 
				if (pointer % 2 == 0) {
					
					// Convert character to uppercase for even position and append into key
					generateKey += Character.toUpperCase(key.charAt(i));
					
				} else {
					generateKey += key.charAt(i);
				}
				pointer++;
			}
		}
		return generateKey;
	}
	
	// Check valid input that contains at least 6 characters
	public String checkInput(String word) {
		// Regex for user input string
		String regex = "[a-zA-z]{6,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(word);
		
		// Condition to match the word to regex
		if(matcher.matches()) {
			// If matches return word
			return word;
		}
		// else return empty string
		return "";
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter word: ");
		String word = input.nextLine();
		
		Program p = new Program();
		
		// String to store generated key through method call
		String genratedKey = p.CleanseAndInvert(word);
		
		if(genratedKey.isEmpty()) {
			System.out.println("Invalid input");
		} else {
			System.out.println("The generated key is - " + genratedKey);
		}
		input.close();
	}

}
