// Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch

import java.util.Scanner;

class RocketLaunch2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter counter value: ");
		int counter = input.nextInt();
		for (int count = counter; count > 0; count--) {
			System.out.print(count + " ");
		}
		input.close();
	}
}