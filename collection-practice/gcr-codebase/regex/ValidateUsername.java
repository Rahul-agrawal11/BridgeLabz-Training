package regex;

import java.util.regex.*;
import java.util.Scanner;

public class ValidateUsername {
	
	// Method to check valid username
	public static boolean validateName(String username) {
		
		String regex = "^([a-zA-Z])[a-zA-Z0-9_]{5,15}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(username);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = input.nextLine();
		boolean isUsername = validateName(username);
		
		if(isUsername) {
			System.out.println(username + " Valid");
		} else {
			System.out.println(username + " Invalid");
		}
		input.close();
	}

}
