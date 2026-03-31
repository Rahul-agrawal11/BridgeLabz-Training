import java.util.Scanner;

class FibonacciGenerator {

    // Takes number of terms from user
    public static int takeInput(Scanner input) {
        System.out.print("Enter number of terms: ");
        return input.nextInt();
    }

    // Generates and prints Fibonacci sequence
    public static String generateFibonacci(int n) {
        if (n <= 0) return "Invalid input";

        int a = 0, b = 1;
        String result = a + " ";

        for (int i = 2; i <= n; i++) {
            result += b + " ";
            int sum = a + b;
            a = b;
            b = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = takeInput(input);
        System.out.println("Fibonacci Sequence:");
        System.out.println(generateFibonacci(n));
        input.close();
    }
}