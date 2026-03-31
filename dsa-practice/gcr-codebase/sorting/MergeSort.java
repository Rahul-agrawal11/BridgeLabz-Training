package sorting;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSort {
	
	public static int[] mergeSort(int[] bookPrice) {
		
		if (bookPrice.length <= 1) {
			return bookPrice;
		}
		
		int mid = bookPrice.length / 2;
		
		int[] left = mergeSort(Arrays.copyOfRange(bookPrice, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(bookPrice, mid, bookPrice.length));
		
		return merge(left, right);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] sortedPrice = new int[left.length + right.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				sortedPrice[k] = left[i];
				i++;
			} else {
				sortedPrice[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < left.length) {
			sortedPrice[k] = left[i];
			i++;
			k++;
		}
		
		while (j < right.length) {
			sortedPrice[k] = right[j];
			j++;
			k++;
		}
		return sortedPrice;
	}
	
	public static void main(String[] args) {
		try {
			// User input
			Scanner input = new Scanner(System.in);
		
			// Input number of total books
			System.out.print("Enter number of total books: ");
			int totalBooks = input.nextInt();
		
			int[] bookPrices = new int[totalBooks];
		
			// Input each book price
			System.out.println("Enter price for " + totalBooks + " books: ");
			for (int i = 0; i < totalBooks; i++) {
			bookPrices[i] = input.nextInt();
			}
		
			// Method call
			int[] ans = MergeSort.mergeSort(bookPrices);
			System.out.println("Sorted Book Prices: " + Arrays.toString(ans));
			
			input.close();
			
			// To catch error
		} catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException.");
		}
	}
}
