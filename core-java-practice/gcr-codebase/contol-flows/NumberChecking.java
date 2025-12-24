// Write a program to check whether a number is positive, negative, or zero.

import java.util.Scanner;

class NumberChecking {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		if(number > 0){
			System.out.println("Positive");
		} else if (number < 0) {
			System.out.println("Negative");
		} else {
			System.out.println("Zero");
		}
		input.close();
	}
}