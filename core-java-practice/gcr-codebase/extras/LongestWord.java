import java.util.Scanner;

public class LongestWord {

    // static method with return value
    static String findLongestWord(String text) {
        String[] words = text.split(" ");
        String longest = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = input.nextLine();

        String longestWord = findLongestWord(text);

        System.out.println("The longest word is: " + longestWord);
    }
}
