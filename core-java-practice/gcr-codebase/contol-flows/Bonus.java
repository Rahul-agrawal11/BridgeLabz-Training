// Create a program to find the bonus of employees based on their years of service.

import java.util.Scanner;

class Bonus {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter salary: ");
		int salary = input.nextInt();
		System.out.print("Enter year of service: ");
		int serviceYear = input.nextInt();
		if (serviceYear > 5) {
			double bonus = salary * 0.05;
			System.out.println("The bonus amount is: " + bonus);
		} else {
			System.out.println("The bonus amount is: 0");
		}
		input.close();
	}
}