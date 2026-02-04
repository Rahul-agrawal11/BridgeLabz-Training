package FunctionalInterface;

import java.util.regex.*;
import java.util.Scanner;

interface SecurityUtils {
	static boolean isValidPassword(String password) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#@$])[A-Za-z\\d#@$]{8,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		if(m.matches()) {
			return true;
		}
		return false;
	}
}

public class PasswordStrengthValidator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		
		if(SecurityUtils.isValidPassword(password)) {
			System.out.println("Password is valid");
		} else {
			System.out.println("Password is invalid");
		}
		sc.close();
	}
}
