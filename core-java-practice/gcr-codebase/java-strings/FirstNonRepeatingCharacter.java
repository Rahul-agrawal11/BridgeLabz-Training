import java.util.Scanner;

class FirstNonRepeatingCharacter {

    // Method to find first non-repeating character
    public static char firstUniqueChar(String text) {
        int[] freq = new int[256]; // ASCII character set

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return ' '; // if no unique character found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.next();

        char result = firstUniqueChar(text);

        if (result != ' ') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        input.close();
    }
}
