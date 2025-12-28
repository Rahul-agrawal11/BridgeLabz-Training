import java.util.Scanner;

public class QuotientAndRemainder {

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number (dividend): ");
        int number = input.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        // Method call
        int[] result = findRemainderAndQuotient(number, divisor);

        // Output
        System.out.println("Quotient is: " + result[0]);
        System.out.println("Remainder is: " + result[1]);

        input.close();
    }
}
