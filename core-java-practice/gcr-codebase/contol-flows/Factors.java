// Create a program to find the factors of a number taken as user input.

import java.util.Scanner;

class Factors {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		if (number > 0) {
			for (int i = 1; i < number; i++) {
				if (number % i == 0) {
					System.out.print(i + " ");
				}
			}
		} else {
			System.out.println("Please enter a positive number.");
		}
		input.close();
	}
}