// Create a program to count the number of digits in an integer.

import java.util.Scanner;

class CountDigits {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int orgNumber = number;
		int count = 0;
		while (number > 0) {
			number /= 10;
			count++;
		}
		
		System.out.println("Length of " + orgNumber + " is: " + count);
		input.close();
	}
}