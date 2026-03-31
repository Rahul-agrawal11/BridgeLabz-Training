import java.util.Scanner;

public class CompareStrings {

    // static method with return value
    static String compareLex(String text1, String text2) {
        int len = Math.min(text1.length(), text2.length());

        for (int i = 0; i < len; i++) {
            char ch1 = text1.charAt(i);
            char ch2 = text2.charAt(i);

            if (ch1 < ch2) {
                return "\"" + text1 + "\" comes before \"" + text2 + "\" in lexicographical order";
            } else if (ch1 > ch2) {
                return "\"" + text2 + "\" comes before \"" + text1 + "\" in lexicographical order";
            }
        }

        // If all matched, shorter string comes first
        if (text1.length() < text2.length()) {
            return "\"" + text1 + "\" comes before \"" + text2 + "\" in lexicographical order";
        } else if (text1.length() > text2.length()) {
            return "\"" + text2 + "\" comes before \"" + text1 + "\" in lexicographical order";
        } else {
            return "Both strings are equal";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String text1 = input.nextLine();

        System.out.print("Enter second string: ");
        String text2 = input.nextLine();

        String result = compareLex(text1, text2);
        System.out.println(result);
    }
}
