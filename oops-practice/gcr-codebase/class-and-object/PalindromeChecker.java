import java.util.Scanner;

public class PalindromeChecker {

    // Method to check palindrome
    static boolean toCheckPalindrome(String text) {

        // Remove spaces and convert to lowercase
        String cleanedText = text.replaceAll("\\s", "").toLowerCase();

        int start = 0;
        int end = cleanedText.length() - 1;

        while (start < end) {
            if (cleanedText.charAt(start) != cleanedText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method to display result
    static void displayResult(String text) {
        if (toCheckPalindrome(text)) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // First input
        System.out.print("Enter text: ");
        String text1 = input.nextLine();
        displayResult(text1);

        // Second input
        System.out.print("Enter text: ");
        String text2 = input.nextLine();
        displayResult(text2);
    }
}
