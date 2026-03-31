import java.util.Scanner;

public class ChocolateDistribution {

    // Method to find chocolates per child and remaining chocolates
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Method call
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Output
        System.out.println("Each child will get " + result[0] + " chocolates");
        System.out.println("Remaining chocolates are " + result[1]);

        input.close();
    }
}
