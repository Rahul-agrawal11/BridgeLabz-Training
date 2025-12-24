// Create a program to check if a number taken from the user is a Harshad Number.

import java.util.Scanner;

class HarshadNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int sum = 0;
		int originalNumber = number;
		
		while (number > 0) {
			int digit = number % 10;
			sum += digit;
			number /= 10;
		}
		
		if (originalNumber % sum == 0) {
			System.out.println(originalNumber + " is a Harshad Number.");
		} else {
			System.out.println(originalNumber + " is not a Harshad Number.");
		}
		input.close();
	}
}