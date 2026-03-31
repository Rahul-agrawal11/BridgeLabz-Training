import java.util.Scanner;

class LowerCaseComparison {

    // Method to convert string to lowercase using charAt() and ASCII logic
    public static String toLowerCaseUsingCharAt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is uppercase (A-Z)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // ASCII conversion
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

        // User-defined lowercase conversion
        String charAtLower = toLowerCaseUsingCharAt(text);

        // Built-in lowercase conversion
        String builtInLower = text.toLowerCase();

        // Display both results
        System.out.println("Lowercase using charAt(): " + charAtLower);
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);

        // Compare results
        boolean result = compareUsingCharAt(charAtLower, builtInLower);

        if (result) {
            System.out.println("Both lowercase results are SAME.");
        } else {
            System.out.println("Both lowercase results are DIFFERENT.");
        }

        input.close();
    }
}
