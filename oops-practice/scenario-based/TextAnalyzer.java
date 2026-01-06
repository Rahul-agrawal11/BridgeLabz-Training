import java.util.Scanner;

class TextAnalyzer {

    // Splits paragraph into words using whitespace
    public static String[] splitParagraph(String para) {
        return para.trim().split("\\s+");
    }

    // Counts total number of words
    public static int countWords(String para) {
        String[] words = splitParagraph(para);
        return words.length;
    }

    // Finds the longest word in the paragraph
    public static String findLongestWord(String para) {
        String[] words = splitParagraph(para);

        if (words.length == 0) {
            return "";
        }

        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Replaces a word with another (case-insensitive)
    public static String replaceWord(String para, String oldWord, String newWord) {
        return para.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Read paragraph input
        System.out.print("Enter paragraph: ");
        String para = input.nextLine();

        // Handle empty or spaces-only input
        if (para == null || para.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        // Display analysis results
        System.out.println("\nParagraph Analysis:");
        System.out.println("Word Count: " + countWords(para));
        System.out.println("Longest Word: " + findLongestWord(para));

        // Read replacement words
        System.out.print("\nEnter word to replace: ");
        String oldWord = input.next();

        System.out.print("Enter new word: ");
        String newWord = input.next();

        // Display updated paragraph
        System.out.println("\nUpdated Paragraph:");
        System.out.println(replaceWord(para, oldWord, newWord));

        input.close();
    }
}