import java.util.Scanner;

public class ReplaceWord {

    // static method with return value
    static String replaceWord(String text, String oldWord, String newWord) {
        String[] words = text.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result = result + newWord;
            } else {
                result = result + words[i];
            }

            if (i < words.length - 1) {
                result = result + " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = input.nextLine();

        System.out.print("Enter word to replace: ");
        String oldWord = input.nextLine();

        System.out.print("Enter new word: ");
        String newWord = input.nextLine();

        String modifiedText = replaceWord(text, oldWord, newWord);

        System.out.println("Modified Sentence: " + modifiedText);
    }
}
