// Create a program to find the power of a number.

import java.util.Scanner;

class PowerOfNumber2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		System.out.print("Enter the power: ");
		int power = input.nextInt();
		int result = 1;
		
		if (number > 0 && power > 0) {
			int counter = 1;
			while (counter <= power) {
				result = result * number;
			    counter++;
			}
		}
		System.out.println("Result: " + result);
		input.close();
	}
}