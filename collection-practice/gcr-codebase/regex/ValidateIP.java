package regex;

import java.util.Scanner;
import java.util.regex.*;

public class ValidateIP {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter IP Address: ");
		String ipAddress = input.nextLine();
		
		String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ipAddress);
		
		if(matcher.find()) {
			System.out.println("Valid IP Address");
		} else {
			System.out.println("Invalid IP Address");
		}
		input.close();
	}
}
