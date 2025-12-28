import java.util.Scanner;

class GcdLcmCalculator {

    // Takes input
    public static int takeInput(Scanner input, String message) {
        System.out.print(message);
        return input.nextInt();
    }

    // Calculates GCD using Euclidean algorithm
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    // Calculates LCM using GCD
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1 = takeInput(input, "Enter first number: ");
        int num2 = takeInput(input, "Enter second number: ");

        System.out.println("GCD: " + findGCD(num1, num2));
        System.out.println("LCM: " + findLCM(num1, num2));

        input.close();
    }
}