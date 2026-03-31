import java.util.Scanner;

class SubStringComparison {

    // Method to create substring using charAt()
    public static String subStringUsingCharAt(String s, int startIndex, int endIndex) {
        String subString = "";
        for (int i = startIndex; i < endIndex; i++) {
            subString += s.charAt(i);
        }
        return subString;
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

        System.out.println("Enter string:");
        String s = input.next();

        System.out.println("Enter start index:");
        int startIndex = input.nextInt();

        System.out.println("Enter end index:");
        int endIndex = input.nextInt();

        // Index validation
        if (startIndex < 0 || endIndex > s.length() || startIndex >= endIndex) {
            System.out.println("Invalid index range!");
        } else {
            // Substring using built-in method
            String subStringBuiltIn = s.substring(startIndex, endIndex);

            // Substring using charAt()
            String subStringCharAt = subStringUsingCharAt(s, startIndex, endIndex);

            System.out.println("Substring using charAt(): " + subStringCharAt);
            System.out.println("Substring using substring(): " + subStringBuiltIn);

            // Compare both substrings
            boolean result = compareUsingCharAt(subStringCharAt, subStringBuiltIn);

            if (result) {
                System.out.println("Both the substrings are SAME.");
            } else {
                System.out.println("Both the substrings are DIFFERENT.");
            }
        }

        input.close();
    }
}
