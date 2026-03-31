import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to calculate sum of n natural numbers using loop
    public static int calculateSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        // Method call
        int result = calculateSum(n);

        // Output
        System.out.println("The sum of first " + n + " natural numbers is " + result);

        input.close();
    }
}
