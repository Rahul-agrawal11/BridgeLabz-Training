import java.util.Scanner;

class StringSplit {

    // Method to find length without using length()
    public static int findLengthWithoutLength(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitUsingCharAt(String text) {

        int length = findLengthWithoutLength(text);

        // Step 1: Count number of words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        spaceIndexes[index++] = -1; // starting boundary

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = length; // ending boundary

        // Step 3: Extract words using indexes
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take full text input
        System.out.println("Enter text:");
        String text = input.nextLine();

        // User-defined split
        String[] charAtResult = splitUsingCharAt(text);

        // Built-in split
        String[] splitResult = text.split(" ");

        // Compare results
        boolean result = compareStringArrays(charAtResult, splitResult);

        System.out.println("Result using charAt():");
        for (String word : charAtResult) {
            System.out.println(word);
        }

        System.out.println("\nResult using split():");
        for (String word : splitResult) {
            System.out.println(word);
        }

        if (result) {
            System.out.println("\nBoth split results are SAME.");
        } else {
            System.out.println("\nBoth split results are DIFFERENT.");
        }

        input.close();
    }
}
