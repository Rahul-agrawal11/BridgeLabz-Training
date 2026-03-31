// Write a program to check for the natural number and write the sum of n natural numbers 

import java.util.Scanner;

class SumOfNaturalNumbers {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		if (number >= 0) {
			double sum = number * ((number + 1) / 2.0);
			System.out.println("The sum of " + number + " natural numbers is " + sum);
		} else {
			System.out.println("The number " + number + " is not a natural number");
		}
		input.close();
	}
}