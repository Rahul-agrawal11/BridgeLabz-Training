import java.util.Scanner;

class TrimUsingCharAt {

    // Find start and end index after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    // Create substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    // Compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

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

    // Main Method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = input.nextLine(); 

        // Custom trim using charAt()
        int[] indexes = findTrimIndexes(text);
        String customTrim = createSubstring(text, indexes[0], indexes[1]);

        // Built-in trim()
        String builtInTrim = text.trim();

        // Compare both results
        boolean result = compareStrings(customTrim, builtInTrim);

        System.out.println("Custom Trim Result : \"" + customTrim + "\"");
        System.out.println("Built-in Trim Result: \"" + builtInTrim + "\"");

        if (result) {
            System.out.println("Both strings are SAME.");
        } else {
            System.out.println("Both strings are DIFFERENT.");
        }

        input.close();
    }
}
