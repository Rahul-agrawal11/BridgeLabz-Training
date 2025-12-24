/* Write a program to create a basic calculator for addition, subtraction, multiplication, and division. 
The program should ask for two numbers (floating point) and perform all the operations */

import java.util.Scanner;

class BasicCalculator {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number 1: ");
		float number1 = input.nextFloat();
		
		System.out.print("Enter number 2: ");
		float number2 = input.nextFloat();
		
		float addition = number1 + number2;
		float subtraction = number1 - number2;
		float multiplication = number1 * number2;
		float division = number1 / number2;
		
		System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + "," + subtraction + "," + multiplication + ", and " + division);
		
		input.close();
	}
}
