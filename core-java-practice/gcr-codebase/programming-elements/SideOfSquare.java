// Write a program to find the side of the square whose parameter you read from the user 

import java.util.Scanner;

class SideOfSquare {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the perimeter of square: ");
		int perimeter = input.nextInt();
		
		int side = perimeter / 4;
		
		System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
		input.close();
	}
}