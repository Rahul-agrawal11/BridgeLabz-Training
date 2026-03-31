package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
	
	// Method to perform division of two numbers
	public static void division(Scanner input) {
		try {
			// Ask user to enter first number
			System.out.println("Enter number 1: ");
			int num1 = input.nextInt(); // may throw InputMismatchException
			
			// Ask user to enter second number
			System.out.println("Enter number 2: ");
			int num2 = input.nextInt(); // may throw InputMismatchException
			
			// Perform division
			int result = num1 / num2; // may throw ArithmeticException if num2 = 0
			
			// Print result
			System.out.println("Result: " + result);
		
		} 
		// Handles exception when user enters non-numeric input
		catch(InputMismatchException e) {
			System.out.println("Input a valid number.");
		} 
		// Handles exception when division by zero occurs
		catch(ArithmeticException e) {
			System.out.println("Can't divide by zero.");
		}
	}

	public static void main(String[] args) {
		// Create Scanner object to take input from user
		Scanner input = new Scanner(System.in);
		
		// Call division method
		division(input);
	}
}