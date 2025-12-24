// Create a program to find the multiplication table of a number entered by the user from 6 to 9.

import java.util.Scanner;

class Table {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int i = 1;
		if (number > 5 && number < 10) {
			while (i <= 10) {
				System.out.println(number + " X " +  i + " = " + number * i);
				i++;
			}
		} else {
			System.out.println("Enter number in range of 6 to 9.");
		}
		input.close();
	}
}