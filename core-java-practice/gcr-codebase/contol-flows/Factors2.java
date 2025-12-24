// Create a program to find the factors of a number taken as user input.

import java.util.Scanner;

class Factors2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		if (number > 0) {
			int counter = 1;
			while (counter < number) {
				if (number % counter == 0) {
					System.out.print(counter + " ");
				}
				counter++;
			}
		} else {
			System.out.println("Please enter a positive number.");
		}
		input.close();
	}
}