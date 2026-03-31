import java.util.Scanner;

class PrimeNumberChecker {

    // Takes integer input from the user
    public static int takeInput(Scanner input) {
        System.out.print("Enter a number: ");
        return input.nextInt();
    }

    // Checks whether the given number is prime
    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false; // Numbers <= 1 are not prime
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Not prime
            }
        }

        return true; // Prime
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num = takeInput(input);

        if (isPrime(num)) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is NOT a Prime number.");
        }

        input.close();
    }
}