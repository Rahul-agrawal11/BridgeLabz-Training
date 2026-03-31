package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlateNumber {

	// Method to check valid license plate number
	public static boolean validateNumber(String plateNumber) {
		
		String regex = "^([A-Z]){2}\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(plateNumber);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter License Plate Number: ");
		String plateNumber = input.nextLine();
		boolean isPlateNumber = validateNumber(plateNumber);
		
		if(isPlateNumber) {
			System.out.println(plateNumber + " Valid");
		} else {
			System.out.println(plateNumber + " Invalid");
		}
		input.close();
	}
}
