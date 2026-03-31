// Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch

import java.util.Scanner;

class RocketLaunch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Counter value: ");
		int counter = input.nextInt();
		while(counter > 0) {
			System.out.print(counter-- + " ");
		}
		input.close();
	}
}