import java.util.Scanner;

class FactorialRecursion {

    // Takes integer input
    public static int takeInput(Scanner input) {
        System.out.print("Enter a number: ");
        return input.nextInt();
    }

    // Recursive factorial calculation
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = takeInput(input);
        System.out.println("Factorial of " + num + " is: " + factorial(num));
        input.close();
    }
}