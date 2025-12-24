// Write a Program to check if the given number is a prime number or not

import java.util.Scanner;

class PrimeNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		boolean isPrime = false;
		int i = 2;
		while (i <= number) {
			if (number % i == 0 && number != 2) {
				isPrime = false;
				break;
			} else {
				i++;
				isPrime = true;
			}
		}
		
		if (isPrime) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}
		input.close();
	}
}