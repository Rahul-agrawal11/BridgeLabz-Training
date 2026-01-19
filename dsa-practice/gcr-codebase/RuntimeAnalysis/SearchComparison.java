package RuntimeAnalysis;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchComparison {
	
	// Performs Linear Search on an array
	// Time Complexity: O(n)
	public static long linearSearch(int[] dataset, int element) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Traverse the array sequentially
		for (int i = 0; i < dataset.length; i++) {
			if (dataset[i] == element) {
				// Element found, stop searching
				break;
			}
		}
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return time taken in nanoseconds
		return endTime - startTime;
	}
	
	// Performs Binary Search on an array
	// Time Complexity: O(log n)
	// Note: Array must be sorted before applying binary search
	public static long binarySearch(int[] dataset, int element) {
		
		// Sort the dataset before binary search
		Arrays.sort(dataset);
		
		int start = 0;
		int end = dataset.length - 1;
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Binary search logic
		while (start <= end) {
			
			int mid = (start + end) / 2;
			
			if (dataset[mid] == element) {
				// Element found
				break;
			} else if (dataset[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return time taken in nanoseconds
		return endTime - startTime;
	}

	public static void main(String[] args) {
		
		// Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Ask user for dataset size
		System.out.println("Enter the size of dataset: ");
		int n = input.nextInt();
		
		// Create dataset array
		int[] dataset = new int[n];
		
		// Random number generator
		Random random = new Random();
		
		// Fill array with random values
		for (int i = 0; i < n; i++) {
			dataset[i] = random.nextInt(dataset.length * 10);
		}
		
		// Measure time for linear search
		long linearTime = linearSearch(dataset, 15);
		
		// Measure time for binary search
		long binaryTime = binarySearch(dataset, 15);
		
		// Display execution times in milliseconds
		System.out.println("Time taken by Linear Search: " 
				+ linearTime / 1_000_000.0 + " ms");
		
		System.out.println("Time taken by Binary Search: " 
				+ binaryTime / 1_000_000.0 + " ms");
		
		// Close scanner resource
		input.close();
	}
}