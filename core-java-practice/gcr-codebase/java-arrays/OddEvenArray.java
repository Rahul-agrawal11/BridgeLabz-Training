
import java.util.Scanner;

class OddEvenArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Get input number
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check for natural number
        if (number <= 0) {
            System.err.println("Error: Please enter a natural number greater than 0.");
            input.close();
            return;
        }

        // Create arrays for odd and even numbers
        int size = number / 2 + 1;
        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];

        // Index variables
        int evenIndex = 0;
        int oddIndex = 0;

        // Store odd and even numbers
        for (int i = 1; i <= number; i++) {

            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print even numbers
        System.out.println("\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        input.close();
    }
}
