// Create a program to find all the multiples of a number taken as user input below 100.

import java.util.Scanner;

class FactorsBelow100Two {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		if (number > 0 && number < 100) {
			int counter = number;
			while (counter >= 1) {
				if (number % counter == 0) {
					System.out.print(counter + " ");
				}
				counter--;
			} 
		} else {
			System.out.println("Please enter a positive number that is below to 100.");
		}
		input.close();
	}
}