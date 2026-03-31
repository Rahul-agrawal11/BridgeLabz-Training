import java.util.Scanner;

class ShortestLongestWord {

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text into words using charAt()
    public static String[] splitText(String text) {
        int textLength = findLength(text);
        int wordCount = 1;

        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        String word = "";
        int index = 0;

        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                words[index++] = word;
                word = "";
            }
        }
        words[index] = word;

        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] wordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }
        return table;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestAndLongest(String[][] table) {
        int shortestIndex = 0;
        int longestIndex = 0;

        int shortestLength = Integer.parseInt(table[0][1]);
        int longestLength = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);

            if (length < shortestLength) {
                shortestLength = length;
                shortestIndex = i;
            }

            if (length > longestLength) {
                longestLength = length;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = input.nextLine();

        String[] words = splitText(text);
        String[][] table = wordLengthTable(words);
        int[] result = findShortestAndLongest(table);

        System.out.println("\nWords and Lengths:");
        System.out.println("------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + " : " + table[i][1]);
        }

        System.out.println("\nShortest Word: " + table[result[0]][0]);
        System.out.println("Longest Word : " + table[result[1]][0]);

        input.close();
    }
}
