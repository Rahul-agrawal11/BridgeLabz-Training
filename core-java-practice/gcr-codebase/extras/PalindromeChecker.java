import java.util.Scanner;

class PalindromeChecker {

    // Takes string input
    public static String takeInput(Scanner input) {
        System.out.print("Enter a string: ");
        return input.nextLine();
    }

    // Checks palindrome condition
    public static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Displays result
    public static String displayResult(String text) {
        return isPalindrome(text)
                ? "It is a Palindrome."
                : "It is NOT a Palindrome.";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = takeInput(input);
        System.out.println(displayResult(text));
        input.close();
    }
}
