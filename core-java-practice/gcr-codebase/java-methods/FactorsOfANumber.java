import java.util.Scanner;

public class FactorsOfANumber {
	
	// Method to find factors and store them
	public static int[] factors(int number) {
		int temp = number;
		int count = 0;
		
		for (int i = 1; i < number; i++) {
			if(number % i == 0) {
				count++;
			}
		}
		
		int[] factArr = new int[count];
		
		int index = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				factArr[index++] = i;
			}
		}
		return factArr;
	}
	
	// Method to find greatest factor
	public static int findGreatestFact(int number) {
		int[] factArr = factors(number);
		
		int greatest = Integer.MIN_VALUE;
		
		int index = 0;
		while (index < factArr.length) {
			if (greatest < factArr[index]) {
				greatest = factArr[index];
			}
			index++;
		}
		return greatest;
	}
	
	// Method to calculate sum of factors
	public static int toCalculateSum(int number) {
		int[] factArr = factors(number);
		
		int sum = 0; 
		for (int i = 0; i < factArr.length; i++) {
			sum += factArr[i];
		}
		return sum;
	}
	
	// Method to calculate product of factors
	public static int toCalculateProduct(int number) {
		int[] factArr = factors(number);
		
		int product = 1; 
		for (int i = 0; i < factArr.length; i++) {
			product *= factArr[i];
		}
		return product;
	}
	
	// Method to calculate product of the cube of the factors
	public static int toCalculateCubeProduct(int number) {
		int[] factArr = factors(number);
		
		int cubeProduct = 1; 
		for (int i = 0; i < factArr.length; i++) {
			cubeProduct *= Math.pow(factArr[i], 3);
		}
		return cubeProduct;
	}

	public static void main(String[] args) {
		
		// Taking user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = input.nextInt();
		
		// Method call
		int[] factArr = factors(number);
		int greatest = findGreatestFact(number);
		int product = toCalculateProduct(number);
		int cubeProduct = toCalculateCubeProduct(number);
		
		// Display results
		System.out.println("Results: ");
		
		System.out.print("Factors: ");
		for (int fact : factArr) {
			System.out.print(fact + " ");
		}
		System.out.println();
		
		System.out.println("Greatest factor: " + greatest);
		System.out.println("Product of factors: " + product);
		System.out.println("Product of the cube of the factors: " + cubeProduct);	
	}
}