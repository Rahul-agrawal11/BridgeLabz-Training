import java.util.Scanner;

public class NumberChecker6 {

    // Method to calculate sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Method to check if a number is Perfect
    public static boolean isPerfectNumber(int number) {
        return sumOfProperDivisors(number) == number;
    }

    // Method to check if a number is Abundant
    public static boolean isAbundantNumber(int number) {
        return sumOfProperDivisors(number) > number;
    }

    // Method to check if a number is Deficient
    public static boolean isDeficientNumber(int number) {
        return sumOfProperDivisors(number) < number;
    }

    // Method to calculate factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;

        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if a number is Strong Number
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("\nResults:");

        if (isPerfectNumber(number)) {
            System.out.println(number + " is a Perfect Number");
        } else {
            System.out.println(number + " is NOT a Perfect Number");
        }

        if (isAbundantNumber(number)) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is NOT an Abundant Number");
        }

        if (isDeficientNumber(number)) {
            System.out.println(number + " is a Deficient Number");
        } else {
            System.out.println(number + " is NOT a Deficient Number");
        }

        if (isStrongNumber(number)) {
            System.out.println(number + " is a Strong Number");
        } else {
            System.out.println(number + " is NOT a Strong Number");
        }

        input.close();
    }
}
