import java.util.Scanner;

public class AnagramCheck {

    // static method with return value
    static boolean areAnagrams(String text1, String text2) {
        text1 = text1.replace(" ", "").toLowerCase();
        text2 = text2.replace(" ", "").toLowerCase();

        if (text1.length() != text2.length()) {
            return false;
        }

        int[] freq = new int[256];

        for (int i = 0; i < text1.length(); i++) {
            freq[text1.charAt(i)]++;
            freq[text2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String text1 = input.nextLine();

        System.out.print("Enter second string: ");
        String text2 = input.nextLine();

        boolean result = areAnagrams(text1, text2);

        if (result) {
            System.out.println("The strings are Anagrams");
        } else {
            System.out.println("The strings are NOT Anagrams");
        }
    }
}
