// 7. Reverse Integer

import java.util.Scanner;

class ReverseInteger {

    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int remainder = x % 10;
            x /= 10;

            // Overflow check
            if (reversed > Integer.MAX_VALUE / 10 ||
               (reversed == Integer.MAX_VALUE / 10 && remainder > 7))
                return 0;

            if (reversed < Integer.MIN_VALUE / 10 ||
               (reversed == Integer.MIN_VALUE / 10 && remainder < -8))
                return 0;

            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }

    // Main function for user input
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int x = input.nextInt();

        int result = reverse(x);

        System.out.println("Reversed integer: " + result);

        input.close();
    }
}
