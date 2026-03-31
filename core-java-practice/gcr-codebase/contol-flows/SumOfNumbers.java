// Write a program to find the sum of numbers until the user enters 0

import java.util.Scanner;

class SumOfNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double total = 0.0;
		
		boolean isCheck = true;
		while (isCheck) {
			System.out.print("Enter the value to add: ");
			double value = input.nextDouble();
		
			if (value == 0) {
				isCheck = false;
			} 
			else {
				total += value;
				
			}
		}
		System.out.println("Total value: "+ total);
		input.close();
	}
}