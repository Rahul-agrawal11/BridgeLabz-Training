// Write a program to check if the first, second, or third number is the largest of the three.

import java.util.Scanner;

class CheckLargest {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter numberI: ");
		int numberI = input.nextInt();
		
		System.out.print("Enter numberII: ");
		int numberII = input.nextInt();
		
		System.out.print("Enter numberIII: ");
		int numberIII = input.nextInt();
		
		if (numberI > numberII && numberI > numberIII) {
			System.out.println("Is the first number the largest? Yes");
		} else if (numberII > numberI && numberII > numberIII) {
			System.out.println("Is the first number the largest? No. The second number is largest.");
		} else {
			System.out.println("Is the first number the largest? No. The third number is largest.");
		}
		input.close();
	}
}