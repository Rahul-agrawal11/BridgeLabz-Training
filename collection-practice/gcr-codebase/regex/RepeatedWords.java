package regex;

import java.util.regex.*;

public class RepeatedWords {

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex to find repeated words
        String regex = "\\b(\\w+)\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Repeated Words: ");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
