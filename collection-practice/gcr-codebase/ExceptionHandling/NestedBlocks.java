package ExceptionHandling;

import java.util.Scanner;

public class NestedBlocks {

    static void arrayOperations(Scanner input) {

        try { // Outer try block (for array index)
            System.out.println("Enter length of array: ");
            int n = input.nextInt();

            int[] arr = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            System.out.println("Enter index:");
            int index = input.nextInt();

            try { // Inner try block (for division)
                System.out.println("Enter divisor:");
                int div = input.nextInt();

                int result = arr[index] / div;
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        arrayOperations(input);
    }
}
