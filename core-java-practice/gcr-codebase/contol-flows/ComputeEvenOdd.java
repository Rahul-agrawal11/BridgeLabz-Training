// Create a program to print odd and even numbers between 1 to the number entered by the user.

import java.util.Scanner;

class ComputeEvenOdd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int base = 1;
		while (base <= number) {
			if (base % 2 == 0) {
				System.out.println("Number is even: " + base);
			} else {
				System.out.println("Number is odd: " + base);
			}
			base++;
		}
		input.close();
	}
}