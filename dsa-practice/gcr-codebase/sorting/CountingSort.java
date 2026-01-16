package sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CountingSort {

    // Counting Sort method
    public static int[] countingSort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct position (stable)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        return output;
    }

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);

            // Input number of students
            System.out.print("Enter number of students: ");
            int n = input.nextInt();

            int[] ages = new int[n];

            // Input ages
            System.out.println("Enter student ages (10 to 18):");
            for (int i = 0; i < n; i++) {
                ages[i] = input.nextInt();
            }

            // Sort ages
            int[] sortedAges = countingSort(ages);

            // Display result
            System.out.println("Sorted Student Ages:");
            for (int age : sortedAges) {
                System.out.print(age + " ");
            }

            input.close();

        } catch (InputMismatchException e) {
            System.out.println("Error: InputMismatchException.");
        }
    }
}
