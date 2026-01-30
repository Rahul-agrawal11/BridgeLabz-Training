package regex;

//import java.util.regex.Pattern;

public class CensorBadWords {

	public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        // Join words with | and wrap in \b to match whole words only
        // (?i) makes the search case-insensitive
        String regex = "(?i)\\b(" + String.join("|", badWords) + ")\\b";

        // Replace all matches with ****
        String output = input.replaceAll(regex, "****");

        System.out.println(output);
        // Output: This is a **** bad example with some **** words.
    }

}
