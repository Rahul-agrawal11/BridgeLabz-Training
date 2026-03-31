import java.util.Scanner;

class FactorsOfTheNumber {

	// Method to return factors of a number 
	public static int[] factors(int number) {
		int count = 0;
		
		// Count number of factors
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		
		int[] factorsArray = new int[count];
		
		int index = 0;
		
		// Store factors in array
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				factorsArray[index] = i;
				index++;
			}
		}
		return factorsArray;
	}
	
	// Method to calculate sum of all factors
	public static int sumOfFactors(int number) {
		int[] factorsArray = factors(number);
		int factorsSum = 0; 
		
		for (int i = 0; i < factorsArray.length; i++) {
			factorsSum += factorsArray[i];
		}
		return factorsSum;
	}
	
	// Method to calculate product of all factors
	public static int productOfFactors(int number) {
		int[] factorsArray = factors(number);
		int factorsProduct = 1; 
		
		for (int i = 0; i < factorsArray.length; i++) {
			factorsProduct *= factorsArray[i];
		}
		return factorsProduct;
	}
	
	// Method to calculate sum of squares of all factors
	public static int sumOfFactorsSquare(int number) {
		int[] factorsArray = factors(number);
		int factorsSquareSum = 0; 
		
		for (int i = 0; i < factorsArray.length; i++) {
			factorsSquareSum += Math.pow(factorsArray[i], 2);
		}
		return factorsSquareSum;
	}

	public static void main(String[] args) {
		
		// Take user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		// Method call
		int[] factorsArray = factors(number);
		int factorsSum = sumOfFactors(number);
		int factorsProduct = productOfFactors(number);
		int factorsSquareSum = sumOfFactorsSquare(number);
		
		// Display results
		System.out.print("Factors of number " + number + "\n[ ");
		for (int i = 0; i < factorsArray.length; i++) {
			System.out.print(factorsArray[i] + " ");
		}
		System.out.println("]");
		
		System.out.println("Sum of factors: " + factorsSum);
		
		System.out.println("Product of factors: " + factorsProduct);
		
		System.out.println("Sum of square of factors: " + factorsSquareSum);
	}	
}