import java.util.Scanner;

class UpperCaseComparison {

    // Method to convert string to uppercase using charAt() and ASCII logic
    public static String toUpperCaseUsingCharAt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is lowercase (a-z)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // ASCII conversion
            }

            result += ch;
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take complete text input
        System.out.println("Enter text:");
        String text = input.nextLine();

        // User-defined uppercase conversion
        String charAtUpper = toUpperCaseUsingCharAt(text);

        // Built-in uppercase conversion
        String builtInUpper = text.toUpperCase();

        // Display both results
        System.out.println("Uppercase using charAt(): " + charAtUpper);
        System.out.println("Uppercase using toUpperCase(): " + builtInUpper);

        // Compare results
        boolean result = compareUsingCharAt(charAtUpper, builtInUpper);

        if (result) {
            System.out.println("Both uppercase results are SAME.");
        } else {
            System.out.println("Both uppercase results are DIFFERENT.");
        }

        input.close();
    }
}
