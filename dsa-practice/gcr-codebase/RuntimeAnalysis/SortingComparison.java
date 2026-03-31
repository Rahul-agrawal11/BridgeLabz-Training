package RuntimeAnalysis;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingComparison {
	
	// Sorts the array using Bubble Sort
	// Time Complexity: O(n^2) in worst and average case
	public static long bubbleSort(int[] dataset) {
		
		boolean swapped;
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Outer loop for passes
		for (int i = 0; i < dataset.length - 1; i++) {
			swapped = false;
			
			// Inner loop for comparisons
			for (int j = 0; j < dataset.length - i - 1; j++) {
				if (dataset[j] > dataset[j + 1]) {
					
					// Swap adjacent elements
					int temp = dataset[j];
					dataset[j] = dataset[j + 1];
					dataset[j + 1] = temp;
					
					swapped = true;
				}
			}
			
			// If no swaps occurred, array is already sorted
			if (!swapped) {
				break;
			}
		}
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Return time taken
		return endTime - startTime;
	}
	
	// Sorts the array using Merge Sort (recursive)
	// Time Complexity: O(n log n)
	public static int[] mergeSort(int[] dataset) {
		
		// Base condition
		if (dataset.length <= 1) {
			return dataset;
		}

		// Divide array into two halves
		int mid = dataset.length / 2;

		int[] left = mergeSort(Arrays.copyOfRange(dataset, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(dataset, mid, dataset.length));

		// Merge sorted halves
		return merge(left, right);
	}
	
	// Merges two sorted arrays
	public static int[] merge(int[] left, int[] right) {
		
		int[] mergeDataset = new int[left.length + right.length];

		int i = 0, j = 0, k = 0;

		// Compare and merge elements
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				mergeDataset[k++] = left[i++];
			} else {
				mergeDataset[k++] = right[j++];
			}
		}

		// Copy remaining elements from left array
		while (i < left.length) {
			mergeDataset[k++] = left[i++];
		}

		// Copy remaining elements from right array
		while (j < right.length) {
			mergeDataset[k++] = right[j++];
		}

		return mergeDataset;
	}
	
	// Measures execution time of Merge Sort
	public static long measureMergeSortTime(int[] dataset) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Perform merge sort
		int[] sorted = mergeSort(dataset);
		
		// Record end time
		long endTime = System.nanoTime();
		
		// Copy sorted result back to original array
		System.arraycopy(sorted, 0, dataset, 0, dataset.length);

		return endTime - startTime;
	}

	// Sorts the array using Quick Sort
	// Average Time Complexity: O(n log n)
	// Worst Case: O(n^2)
	static int[] quickSort(int[] dataset, int left, int right) {

        // Base condition
        if (left >= right) {
            return dataset;
        }

        int start = left;
        int end = right;

        // Choose pivot element
        int pivot = dataset[left + (right - left) / 2];

        // Partitioning process
        while (start <= end) {

            while (dataset[start] < pivot) {
                start++;
            }

            while (dataset[end] > pivot) {
                end--;
            }

            if (start <= end) {
            	
            	// Swap elements
                int temp = dataset[start];
                dataset[start] = dataset[end];
                dataset[end] = temp;
                
                start++;
                end--;
            }
        }

        // Recursive calls for left and right partitions
        quickSort(dataset, left, end);
        quickSort(dataset, start, right);

        return dataset;
    }
	
	// Measures execution time of Quick Sort
	public static long measureQuickSortTime(int[] dataset) {
		
		// Record start time
		long startTime = System.nanoTime();
		
		// Perform quick sort
		quickSort(dataset, 0, dataset.length - 1);
		
		// Record end time
		long endTime = System.nanoTime();
		
		return endTime - startTime;
	}
	
	public static void main(String[] args) {

		// Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Ask user for dataset size
		System.out.println("Enter the size of dataset: ");
		int n = input.nextInt();

		// Create original dataset
		int[] originalDataset = new int[n];
		Random random = new Random();

		// Fill dataset with random values
		for (int i = 0; i < n; i++) {
			originalDataset[i] = random.nextInt(n * 10);
		}

		// Create copies for fair comparison
		int[] bubbleData = Arrays.copyOf(originalDataset, n);
		int[] mergeData = Arrays.copyOf(originalDataset, n);
		int[] quickData = Arrays.copyOf(originalDataset, n);

		// Measure execution times
		long bubbleSortTime = bubbleSort(bubbleData);
		long mergeSortTime = measureMergeSortTime(mergeData);
		long quickSortTime = measureQuickSortTime(quickData);

		// Display results in milliseconds
		System.out.println("Time taken by Bubble Sort (ms): " 
				+ bubbleSortTime / 1_000_000.0);
		
		System.out.println("Time taken by Merge Sort (ms): " 
				+ mergeSortTime / 1_000_000.0);
		
		System.out.println("Time taken by Quick Sort (ms): " 
				+ quickSortTime / 1_000_000.0);

		// Close scanner
		input.close();
	}
}