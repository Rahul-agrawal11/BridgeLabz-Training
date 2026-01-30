package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {

	// Method to check valid color code
	public static boolean validateCode(String colorCode) {
		
		String regex = "^#[a-fA-F0-9]{6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(colorCode);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Hex Color Code: ");
		String colorCode = input.nextLine();
		boolean isValidCode = validateCode(colorCode);
		
		if(isValidCode) {
			System.out.println(colorCode + " Valid");
		} else {
			System.out.println(colorCode + " Invalid");
		}
		input.close();
	}

}
