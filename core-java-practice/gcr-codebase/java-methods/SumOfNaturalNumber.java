import java.util.Scanner;

public class SumOfNaturalNumber {

	// Method to calculate sum using recursion
	public static int sumUsingRecursion(int number) {
		int sum = 0;
		int i = 1;

		return recursionHelper(sum, i, number);
	}
	
	// Method to return sum
	public static int recursionHelper(int sum, int count, int number) {
		if (count > number) {
			return sum;
		}
		
		return recursionHelper(sum + count, count + 1, number); 
	}
	
	// Method to calculate sum using formula
	public static int sumUsingFormula(int number) {
		int sum = (number * (number + 1)) / 2;
		return sum;
	}

	public static void main(String[] args) {
		
		// Take user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a natural number: ");
		int number = input.nextInt();
		
		if (number < 1) {
			System.out.print("Enter a natural number: ");
			number = input.nextInt();
		}
		
		// Method call
		int sumRecursion = sumUsingRecursion(number);
		int sumFormula = sumUsingFormula(number);
		
		// Compare both results
		if (sumRecursion == sumFormula) {
			System.out.println("Both results are same.");
			System.out.println("Sum using Recursion: " + sumRecursion + "\nSum using Formula: " + sumFormula);
		} else {
			System.out.println("Both results are different.");
		}
	}
}