package ExceptionHandling;

import java.util.Scanner;

public class MultipleCatch {

    public static void arrayOperations(Scanner input) {
        try {
            System.out.println("Enter length of array: ");
            int n = input.nextInt();

            int[] arr = null; // array is null initially

            // Initialize array only if n > 0
            if (n > 0) {
                arr = new int[n];
                System.out.println("Enter elements:");
                for (int i = 0; i < n; i++) {
                    arr[i] = input.nextInt();
                }
            }

            System.out.println("Enter index:");
            int index = input.nextInt();

            // This may throw NullPointerException or ArrayIndexOutOfBoundsException
            System.out.println("Value: " + arr[index]);

        } 
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        arrayOperations(input);
    }
}
