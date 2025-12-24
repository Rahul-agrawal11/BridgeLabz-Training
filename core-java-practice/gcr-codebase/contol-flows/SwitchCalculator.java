// Write a program to create a calculator using switch...case.

import java.util.Scanner;

class SwitchCalculator {
	public static void main(String[] args) {
		System.out.println("Addition(+)");
		System.out.println("Subtraction(-)");
		System.out.println("Multiplication(*)");
		System.out.println("Division(/)");
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the numberI: ");
		int numberI = input.nextInt();
		System.out.print("Enter the numberII: ");
		int numberII = input.nextInt();
		
		System.out.print("Enter operation Symbol: ");
		String operation = input.next();
		
		switch(operation) {
			case "+":
				System.out.print("Addition: " + (numberI + numberII));
				break;
			case "-":
				System.out.print("Subtraction: " + (numberI - numberII));
				break;
			case "*":
				System.out.print("Multiplication: " + (numberI * numberII));
				break;
			case "/":
				System.out.print("Division: " + (numberI / numberII));
				break;
			default: 
				System.out.print("Invalid Operation");
		}
		input.close();
	}
}