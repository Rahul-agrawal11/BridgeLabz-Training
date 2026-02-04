package FunctionalInterface;

import java.util.function.Function;
import java.util.Scanner;

public class StringLengthChecker {

	public static void main(String[] args) {
		int charLimit = 10;
		Function<String, Integer> checkLen = s -> s.length();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Message: ");
		String text = sc.nextLine();
		
		int len = checkLen.apply(text);
		
		if (len > charLimit) {
			System.out.println("Warning: Message exceeded character limit.");
		} else {
			System.out.println("Valid message! lies in character limit.");
		}
		sc.close();
	}

}
