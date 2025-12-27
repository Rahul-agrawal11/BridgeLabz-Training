import java.util.Scanner;

class FizzBuzzProgram {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Check for positive integer
        if (number <= 0) {
            System.err.println("Error: Please enter a positive integer.");
            input.close();
            return;
        }

        // Create String array to store results
        String[] results = new String[number + 1];

        // Loop from 0 to number and save FizzBuzz results
        for (int i = 0; i <= number; i++) {

            if (i == 0) {
                results[i] = "0";
            }
            else if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            }
            else if (i % 3 == 0) {
                results[i] = "Fizz";
            }
            else if (i % 5 == 0) {
                results[i] = "Buzz";
            }
            else {
                results[i] = String.valueOf(i);
            }
        }

        // Display results with position
        System.out.println("\nFizzBuzz Output:");
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        input.close();
    }
}