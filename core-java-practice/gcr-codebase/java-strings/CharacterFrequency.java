import java.util.Scanner;

public class CharacterFrequency {

    // Method to find character frequencies and return as 1D String array
    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        // Nested loop to calculate frequency
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0')
                continue;

            freq[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Count unique characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Create 1D array to store result
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[] frequencies = findFrequency(text);

        System.out.println("\nCharacter Frequencies:");
        for (String s : frequencies) {          
            System.out.println(s);
        }

        input.close();
    }
}
