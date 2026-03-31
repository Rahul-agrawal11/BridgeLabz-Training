// Write a program to find the sum of numbers until the user enters 0

import java.util.Scanner;

class SumOfNumbers2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double total = 0.0;
		
		while (true) {
			System.out.print("Enter the value to add: ");
			double value = input.nextDouble();
		
			if (value <= 0) {
				break;
			} 
			else {
				total += value;	
			}
		}
		System.out.println("Total value: "+ total);
		input.close();
	}
}