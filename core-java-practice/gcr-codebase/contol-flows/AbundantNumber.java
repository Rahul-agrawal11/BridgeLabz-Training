// Create a program to check if a number is an Abundant Number.

import java.util.Scanner;

class AbundantNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int sum = 0;
		int i = 1;
		while (i < number) {
			if (number % i == 0) {
				sum += i;
			}
			i++;
		}
		
		if (sum > number) {
			System.out.println(number + " is an abundant number.");
		} else {
			System.out.println(number + " is not an abundant number.");
		}
		input.close();
	}
}