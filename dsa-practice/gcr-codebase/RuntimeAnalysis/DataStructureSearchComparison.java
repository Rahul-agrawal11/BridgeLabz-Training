package RuntimeAnalysis;

import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearchComparison {
	
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
		
		// Return total time taken
		return endTime - startTime;
	}
		
	// Performs search using HashSet
	// Average Time Complexity: O(1)
	public static long hashing(HashSet<Integer> set, int element) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Hash-based search
		boolean isContains = set.contains(element);
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return total time taken
		return endTime - startTime;
	}
	
	// Performs search using TreeSet
	// Time Complexity: O(log n)
	public static long usingTreeSet(TreeSet<Integer> set, int element) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Tree-based (balanced BST) search
		boolean isContains = set.contains(element);
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return total time taken
		return endTime - startTime;
	}

	public static void main(String[] args) {
		
		// Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Ask user for dataset size
		System.out.println("Enter the size of dataset: ");
		int n = input.nextInt();
		
		// Data structures initialization
		int[] dataset = new int[n];
		HashSet<Integer> hashset = new HashSet<>();
		TreeSet<Integer> treeset = new TreeSet<>();
		
		// Random number generator
		Random random = new Random();
		
		// Fill array, HashSet, and TreeSet with random values
		for (int i = 0; i < n; i++) {
			dataset[i] = random.nextInt(dataset.length * 10);
			hashset.add(random.nextInt(dataset.length * 10));
			treeset.add(random.nextInt(dataset.length * 10));
		}
		
		// Measure search times for element 20
		long linearTime = linearSearch(dataset, 20);
		long hashingTime = hashing(hashset, 20);
		long treeSetTime = usingTreeSet(treeset, 20);

		// Display results in milliseconds
		System.out.println("Time taken by Linear Search: " 
				+ linearTime / 1_000_000.0 + " ms");
		
		System.out.println("Time taken by Hashing Search: " 
				+ hashingTime / 1_000_000.0 + " ms");
		
		System.out.println("Time taken by TreeSet Search: " 
				+ treeSetTime / 1_000_000.0 + " ms");
	}
}