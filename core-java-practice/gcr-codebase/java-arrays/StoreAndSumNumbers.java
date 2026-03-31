import java.util.Scanner;

class StoreAndSumNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array to store up to 10 double values
        double[] numbers = new double[10];

        // Variable to store total sum
        double total = 0.0;

        // Index for array
        int index = 0;

        // Infinite loop to take input
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = input.nextDouble();

            // Break if user enters 0 or negative number
            if (value <= 0) {
                break;
            }

            // Break if array limit is reached
            if (index == 10) {
                System.err.println("Maximum limit of 10 numbers reached.");
                break;
            }

            // Store value in array and increment index
            numbers[index] = value;
            index++;
        }

        // Display numbers and calculate total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Display total
        System.out.println("\nTotal sum of numbers: " + total);

        input.close();
    }
}
