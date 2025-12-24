// Write a program to check whether a person can vote, depending on whether his/her age is greater than or equal to 18.

import java.util.Scanner;

class Eligibity {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Age: ");
		int age = input.nextInt();
		
		if (age >= 18) {
			System.out.println("The person can vote.");
		} else {
			System.out.println("The person cannot vote.");
		}
		input.close();
	}
}