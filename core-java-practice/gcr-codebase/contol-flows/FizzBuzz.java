/* Write a program FizzBuzz, take a number as user input, and check for a positive integer. 
If positive integer, loop and print the number, but for multiples of 3 print "Fizz" instead of the number, 
for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz". */

import java.util.Scanner; 

class FizzBuzz {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive number: ");
		int number = input.nextInt();
		
		if (number > 0) {
		    for (int num = 1; num <= number; num++) {
				if (num % 3 == 0 && num % 5 == 0) {
				    System.out.println("FizzBuzz: " + num);
				} else if (num % 3 == 0) {
					System.out.println("Fizz: " + num);
				} else if (num % 5 == 0) {
					System.out.println("Buzz: " + num);
				}
			}
		} else {
			System.out.println("Please Enter a positive number.");
		}
		input.close();
	}
}

