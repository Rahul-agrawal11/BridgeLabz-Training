package sorting;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BubbleSort {
	
	// Method to sort elements
	public static void bubbleSort(int[] marks, int totalStudents) {
		boolean swapped;
		
		for (int i = 0; i < totalStudents - 1; i++) {
			swapped = false;
			for (int j = 0; j < totalStudents - i - 1; j++) {
				if (marks[j] > marks[j+1]) {
					int temp = marks[j];
					marks[j] = marks[j+1];
					marks[j+1] = temp;
					swapped = true;
				}
			}
			
			// If not swapped means, already sorted.
			if (!swapped) {
				System.out.println("Elements are already sorted.");
				break;
			}
		}
		
		// Display the sorted array
		System.out.println("Sorted marks of students in ascending order: ");
		for (int i = 0; i < totalStudents; i++) {
			System.out.print(marks[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			// User input
			Scanner input = new Scanner(System.in);
		
			// Input number of total students
			System.out.print("Enter number of total students: ");
			int totalStudents = input.nextInt();
		
			int[] marks = new int[totalStudents];
		
			// Input students marks
			System.out.println("Enter marks till " + totalStudents + " students: ");
			for (int i = 0; i < totalStudents; i++) {
			marks[i] = input.nextInt();
			}
		
			// Method call
			BubbleSort.bubbleSort(marks, totalStudents);
			
			input.close();
			
			// To catch error
		} catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException.");
		}
	}
}
