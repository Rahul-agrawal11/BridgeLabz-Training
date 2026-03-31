package RuntimeAnalysis;

import java.util.Scanner;

public class FibonacciComparison {

	// Recursive method to calculate nth Fibonacci number
	// Time Complexity: O(2^n) due to repeated subproblems
	public static int fibonacciRecursive(int n) {
	    
		// Base cases: Fibonacci of 0 or 1
		if (n <= 1) return n;
		
		// Recursive calls
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	// Measures the execution time of the recursive Fibonacci method
	public static long measureFibonacciRecursiveTime(int n) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Call recursive Fibonacci function
		int result = fibonacciRecursive(n);
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return time taken in nanoseconds
		return endTime - startTime;
	}
	
	// Iterative method to calculate nth Fibonacci number
	// Time Complexity: O(n)
	public static int fibonacciIterative(int n) {
	    
		// Initial Fibonacci values
		int a = 0, b = 1, sum;
		
		// Loop from 2 to n to calculate Fibonacci iteratively
		for (int i = 2; i <= n; i++) {
	        sum = a + b;
	        a = b;
	        b = sum;
	    }
		
		// Final Fibonacci value
		return b;
	}

	// Measures the execution time of the iterative Fibonacci method
	public static long measureIterativeRecursiveTime(int n) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Call iterative Fibonacci function
		int result = fibonacciIterative(n);
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return time taken in nanoseconds
		return endTime - startTime;
	}
	
	public static void main(String[] args) {
		
		// Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Prompt user for Fibonacci number
		System.out.println("Enter the number: ");
		int n = input.nextInt();
		
		// Measure execution time of recursive approach
		long recursiveTime = measureFibonacciRecursiveTime(n);
		
		// Measure execution time of iterative approach
		long iterativeTime = measureIterativeRecursiveTime(n);
		
		// Display execution times in milliseconds
		System.out.println("Time taken by recursive approach: " 
				+ recursiveTime / 1_000_000.0 + " ms");
		
		System.out.println("Time taken by iterative approach: " 
				+ iterativeTime / 1_000_000.0 + " ms");
	}
}