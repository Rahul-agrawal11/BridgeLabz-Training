import java.util.Scanner;

class FindUniqueCharactersAndTheirFrequencies {

    // Method to calculate string length without using length()
    public static int toCalculateLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    // Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String text) {
        int len = toCalculateLength(text);
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index++] = text.charAt(i);
            }
        }

        // Exact-sized array
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // Method to count frequency and return 2D array
    public static String[][] countFrequency(String text) {
        int len = toCalculateLength(text);

        // ASCII frequency array
        int[] freq = new int[256];

        // Count frequency of each character
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Get unique characters
        char[] uniqueChar = uniqueCharacters(text);

        // 2D array to store characters and frequencies
        String[][] result = new String[uniqueChar.length][2];

        for (int i = 0; i < uniqueChar.length; i++) {
            result[i][0] = String.valueOf(uniqueChar[i]);
            result[i][1] = String.valueOf(freq[uniqueChar[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.next();

        String[][] charFrequency = countFrequency(text);

        System.out.println("\nUnique characters along with their frequencies:");
        for (int i = 0; i < charFrequency.length; i++) {
            System.out.println(charFrequency[i][0] + " -> " + charFrequency[i][1]);
        }
    }
}