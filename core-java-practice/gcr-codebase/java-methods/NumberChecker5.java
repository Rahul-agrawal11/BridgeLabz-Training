import java.util.Scanner;

public class NumberChecker5 {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a Neon number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Method to check if a number is a Spy number
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Method to check if a number is an Automorphic number
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int temp = number;

        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    // Method to check if a number is a Buzz number
    public static boolean isBuzzNumber(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("\nResults:");

        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is NOT a Prime Number");
        }

        if (isNeonNumber(number)) {
            System.out.println(number + " is a Neon Number");
        } else {
            System.out.println(number + " is NOT a Neon Number");
        }

        if (isSpyNumber(number)) {
            System.out.println(number + " is a Spy Number");
        } else {
            System.out.println(number + " is NOT a Spy Number");
        }

        if (isAutomorphicNumber(number)) {
            System.out.println(number + " is an Automorphic Number");
        } else {
            System.out.println(number + " is NOT an Automorphic Number");
        }

        if (isBuzzNumber(number)) {
            System.out.println(number + " is a Buzz Number");
        } else {
            System.out.println(number + " is NOT a Buzz Number");
        }

        input.close();
    }
}
