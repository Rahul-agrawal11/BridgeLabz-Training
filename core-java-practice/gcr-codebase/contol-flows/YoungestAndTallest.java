/* Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony 
based on their ages and the tallest among the friends based on their heights */

import java.util.Scanner;

class YoungestAndTallest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Amar Age: ");
		int amarAge = input.nextInt();
		
		System.out.print("Enter Akbar Age: ");
		int akbarAge = input.nextInt();
		
		System.out.print("Enter Anthony Age: ");
		int anthonyAge = input.nextInt();
		
		System.out.print("Enter Amar Height: ");
		int amarHeight = input.nextInt();
		
		System.out.print("Enter Akbar Height: ");
		int akbarHeight = input.nextInt();
		
		System.out.print("Enter Anthony Height: ");
		int anthonyHeight = input.nextInt();
		
		if (amarAge < akbarAge && amarAge < anthonyAge) {
			System.out.println("Amar is the youngest.");
		} else if (akbarAge < amarAge && akbarAge < anthonyAge) {
			System.out.println("Akbar is the youngest.");
		} else {
			System.out.println("Anthony is the youngest.");
		}
		
		if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
			System.out.println("Amar is the tallest.");
		} else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
			System.out.println("Akbar is the tallest.");
		} else {
			System.out.println("Anthony is the tallest.");
		}
		input.close();
	}
}