// Write a program to check if a number is divisible by 5

import java.util.Scanner;

class DivisibleByFive {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		if (number % 5 == 0) {
			System.out.println("Is the number " + number + " divisible by 5? Yes");
		} else {
			System.out.println("Is the number " + number + " divisible by 5? No");
		}
		input.close();
	}
}