package regex;

import java.util.Scanner;
import java.util.regex.*;

public class ValidateCreditCard {
	
	public static String visaCard() {
		return "^(4){1}\\d{15}$";
	}
	
	public static String masterCard() {
		return "^(5){1}\\d{15}$";		
	}
	
	public static boolean validateNumber(String number, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);
		if(matcher.find()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. Visa Card");
		System.out.println("2. Master Card");
		System.out.println("Enter your choice: ");
		int choice = input.nextInt();
		input.nextLine();
		String regex = "";
		boolean isValid = false;
		switch(choice) {
			case 1:
				System.out.println("Enter Visa card number: ");
				String cardNumber = input.nextLine();
				regex = visaCard();
				isValid = validateNumber(cardNumber, regex);
				
				if(isValid) {
					System.out.println("Valid");
				} else {
					System.out.println("Invalid");
				}
				break;
			case 2:
				System.out.println("Enter Master card number: ");
				String cardNum = input.nextLine();
				regex = masterCard();
				isValid = validateNumber(cardNum, regex);
				if(isValid) {
					System.out.println("Valid");
				} else {
					System.out.println("Invalid");
				}
				break;
			default:
				System.out.println("Invalid Choice!");
		}
		
		input.close();

	}

}
