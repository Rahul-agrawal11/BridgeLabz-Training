import java.util.Scanner;

class MaximumOfThree {

    // Takes input from the user and returns it
    public static int takeInput(Scanner input, String message) {
        System.out.print(message);
        return input.nextInt();
    }

    // Finds and returns the maximum of three numbers
    public static int findMaximum(int a, int b, int c) {

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num1 = takeInput(input, "Enter first number: ");
        int num2 = takeInput(input, "Enter second number: ");
        int num3 = takeInput(input, "Enter third number: ");

        int maximum = findMaximum(num1, num2, num3);

        System.out.println("Maximum of three numbers is: " + maximum);

        input.close();
    }
}
