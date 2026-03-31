// Create a program to find the maximum number of handshakes among N number of students.

import java.util.Scanner;

class NumberOfHandshakes {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of students: ");
		int numberOfStudents = input.nextInt();
		
		int possibleHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
		
		System.out.println("The number of possible handshakes: " + possibleHandshakes);
		input.close();
	}
}