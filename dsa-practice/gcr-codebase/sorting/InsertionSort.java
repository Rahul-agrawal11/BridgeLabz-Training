package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionSort {
	
	public static void insertionSort(int[] ids, int totalEmployees) {
		
		for (int i = 1; i < totalEmployees; i++) {
			int key = ids[i];
			int j = i - 1;
			
			while (j >= 0 && ids[j] > key) {
				ids[j+1] = ids[j];
				j--;
			}
			ids[j+1] = key;
		}
		
		System.out.println("Sorted Employee IDs: ");
		for (int i = 0; i < totalEmployees; i++) {
			System.out.print(ids[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			// User input
			Scanner input = new Scanner(System.in);
		
			// Input number of total employees
			System.out.print("Enter number of total employees: ");
			int totalEmployees = input.nextInt();
		
			int[] ids = new int[totalEmployees];
		
			// Input id numbers
			System.out.println("Enter id number till " + totalEmployees + " employees: ");
			for (int i = 0; i < totalEmployees; i++) {
			ids[i] = input.nextInt();
			}
		
			// Method call
			InsertionSort.insertionSort(ids, totalEmployees);
			
			input.close();
			
			// To catch error
		} catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException.");
		}
	}
}
