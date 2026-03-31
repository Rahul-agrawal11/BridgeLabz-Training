// Write a program to check if the first is the smallest of the 3 numbers.

import java.util.Scanner;

class CheckSmallest {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter numberI: ");
		int numberI = input.nextInt();
		
		System.out.print("Enter numberII: ");
		int numberII = input.nextInt();
		
		System.out.print("Enter numberIII: ");
		int numberIII = input.nextInt();
		
		if (numberI < numberII && numberI < numberIII) {
			System.out.println("Is the first number the smallest? Yes");
		} else if (numberII < numberI && numberII < numberIII) {
			System.out.println("Is the first number the smallest? No. The second number is smallest.");
		} else {
			System.out.println("Is the first number the smallest? No. The third number is smallest.");
		}
		input.close();
	}
}