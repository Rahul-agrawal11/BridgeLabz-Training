// Write a Program to find the factorial of an integer entered by the user.

import java.util.Scanner;

class Factorial2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int fact = 1;
		if (number > 0) {
			for (int num = number; num > 0; num--) {
				fact *= num;
			}
			System.out.println("The factorial of number " + number + " is: " + fact);
		} else {
			System.out.println("Please enter a positive value.");
		}
		input.close();
	}
}