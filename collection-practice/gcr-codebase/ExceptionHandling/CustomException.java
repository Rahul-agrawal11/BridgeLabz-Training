package ExceptionHandling;

import java.util.Scanner;

// Custom exception class (user-defined exception)
class InvalidAgeException extends Exception {
	
	// Constructor to pass custom error message
	InvalidAgeException(String message) {
		super(message);
	}
}

public class CustomException {
	
	// Method to validate age, may throw InvalidAgeException
	public static void validateAge(int age) throws InvalidAgeException {
		
		// Check if age is less than 18
		if(age < 18) {
			// Throw custom exception with message
			throw new InvalidAgeException("Age must be 18 or above");
		}
		
		// If age is valid, print age
		System.out.println("Access granted!");
	}

	public static void main(String[] args) {
		
		// Create Scanner object to take input
		Scanner input = new Scanner(System.in);
		
		// Ask user to enter age
		System.out.println("Enter your age: ");
		int age = input.nextInt();
		
		// Close scanner
		input.close();
		
		try {
			// Call validateAge method
			validateAge(age);
		} 
		// Catch custom exception
		catch(InvalidAgeException e) {
			// Print error message
			System.out.println("Error: " + e.getMessage());
		}
	}

}
