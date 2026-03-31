package sorting;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickSort {

    static int[] quickSort(int[] prices, int left, int right) {

        if (left >= right) {
            return prices;
        }

        int start = left;
        int end = right;

        int pivot = prices[left + (right - left) / 2]; // pivot VALUE

        while (start <= end) {

            while (prices[start] < pivot) {
                start++;
            }

            while (prices[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = prices[start];
                prices[start] = prices[end];
                prices[end] = temp;
                start++;
                end--;
            }
        }

        // Recursive ranges
        quickSort(prices, left, end);
        quickSort(prices, start, right);

        return prices;
    }

    public static void main(String[] args) {

    	try {
			// User input
			Scanner input = new Scanner(System.in);
		
			// Input number of total product
			System.out.print("Enter number of total products: ");
			int totalProducts = input.nextInt();
		
			int[] productPrices = new int[totalProducts];
		
			// Input each book price
			System.out.println("Enter price for " + totalProducts + " products: ");
			for (int i = 0; i < totalProducts; i++) {
			productPrices[i] = input.nextInt();
			}
			
			// Method call
			productPrices = QuickSort.quickSort(productPrices, 0, productPrices.length - 1);
			
			input.close();
			
			System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
			
			// To catch error
		} catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException.");
		}
    }
}
