package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectionSort {

    // Selection Sort method
    public static int[] selectionSort(int[] examScores) {

        for (int i = 0; i < examScores.length; i++) {

            // Find index of minimum element from i to end
            int minIndex = findMinIndex(examScores, i);

            // Swap current element with minimum element
            int temp = examScores[i];
            examScores[i] = examScores[minIndex];
            examScores[minIndex] = temp;
        }

        return examScores;
    }

    // Helper method to find index of minimum element
    public static int findMinIndex(int[] examScores, int start) {

        int minIndex = start;

        for (int i = start + 1; i < examScores.length; i++) {
            if (examScores[i] < examScores[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);

            // Input number of students
            System.out.print("Enter number of total students: ");
            int totalStudents = input.nextInt();

            int[] examScores = new int[totalStudents];

            // Input exam scores
            System.out.println("Enter exam scores of " + totalStudents + " students:");
            for (int i = 0; i < totalStudents; i++) {
                examScores[i] = input.nextInt();
            }

            // Method call
            int[] sortedScores = selectionSort(examScores);

            // Display sorted result
            System.out.println("Sorted Exam Scores:");
            for (int score : sortedScores) {
                System.out.print(score + " ");
            }

            input.close();

        } catch (InputMismatchException e) {
            System.out.println("Error: InputMismatchException.");
        }
    }
}