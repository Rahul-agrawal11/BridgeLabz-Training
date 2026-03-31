import java.util.Scanner;

class MultiplicationTableSixToNine {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take number input
        System.out.print("Enter a number between 6 and 9: ");
        int number = input.nextInt();

        // Validate input
        if (number < 6 || number > 9) {
            System.err.println("Invalid input! Please enter a number between 6 and 9.");
        } else {

            // Array to store multiplication results (1 to 10)
            int[] multiplicationResult = new int[10];

            // Calculate multiplication table
            for (int i = 1; i <= 10; i++) {
                multiplicationResult[i - 1] = number * i;
            }

            // Display multiplication table
            System.out.println("\nMultiplication Table of " + number + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " * " + i + " = " + multiplicationResult[i - 1]);
            }
        }

        input.close();
    }
}
