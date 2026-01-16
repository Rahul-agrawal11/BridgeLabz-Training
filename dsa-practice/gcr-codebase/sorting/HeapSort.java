package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HeapSort {

    // Heap Sort method
    public static int[] heapSort(int[] salaries) {

        int n = salaries.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap
        for (int i = n - 1; i > 0; i--) {

            // Swap root (max) with last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify reduced heap
            heapify(salaries, i, 0);
        }
        return salaries;
    }

    // Heapify method (Max Heap)
    public static void heapify(int[] salaries, int heapSize, int rootIndex) {

        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        // Check left child
        if (left < heapSize && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check right child
        if (right < heapSize && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If root is not largest
        if (largest != rootIndex) {

            int swap = salaries[rootIndex];
            salaries[rootIndex] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify affected subtree
            heapify(salaries, heapSize, largest);
        }
    }

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);

            // Input number of applicants
            System.out.print("Enter number of job applicants: ");
            int n = input.nextInt();

            int[] salaries = new int[n];

            // Input salary demands
            System.out.println("Enter expected salary of each applicant:");
            for (int i = 0; i < n; i++) {
                salaries[i] = input.nextInt();
            }

            // Sort salaries
            int[] sortedSalaries = heapSort(salaries);

            // Display sorted salaries
            System.out.println("Sorted Salary Demands (Ascending Order):");
            for (int salary : sortedSalaries) {
                System.out.print(salary + " ");
            }

            input.close();

        } catch (InputMismatchException e) {
            System.out.println("Error: InputMismatchException.");
        }
    }
}
