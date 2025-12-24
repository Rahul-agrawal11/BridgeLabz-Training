/* Write an DoubleOperation program by taking a, b, and c as input values and print the following integer 
operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the precedence of the operators. */

import java.util.Scanner;

class DoubleOperations {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter value for a: ");
		double a = input.nextDouble();
		
		System.out.print("Enter value for b: ");
		double b = input.nextDouble();
		
		System.out.print("Enter value for c: ");
		double c = input.nextDouble();
		
		double operation1 = a + b * c;
		double operation2 = a * b + c;
		double operation3 = c + a / b;
		double operation4 = a % b + c;
		
		System.out.println("The results of Int Operations are " + operation1 + "," + operation2 + "," + operation3 + ", and " + operation4);
		input.close();
	}
}