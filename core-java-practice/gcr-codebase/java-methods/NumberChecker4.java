import java.util.Scanner;

public class NumberChecker4 {

    // Method to count digits in a number
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // Method to store digits of a number into an array
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to reverse an array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = storeDigits(number);
        int[] reversedDigits = reverseArray(digits);

        return compareArrays(digits, reversedDigits);
    }

    // Method to check if a number is a duck number
    // (contains at least one non-zero digit)
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);

        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Count digits
        int digitCount = countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        // Store digits
        int[] digits = storeDigits(number);
        System.out.print("Digits array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        // Reverse digits
        int[] reversed = reverseArray(digits);
        System.out.print("Reversed digits array: ");
        for (int d : reversed) {
            System.out.print(d + " ");
        }
        System.out.println();

        // Palindrome check
        if (isPalindrome(number)) {
            System.out.println("The number is a Palindrome.");
        } else {
            System.out.println("The number is NOT a Palindrome.");
        }

        // Duck number check
        if (isDuckNumber(number)) {
            System.out.println("The number is a Duck Number.");
        } else {
            System.out.println("The number is NOT a Duck Number.");
        }

        input.close();
    }
}
