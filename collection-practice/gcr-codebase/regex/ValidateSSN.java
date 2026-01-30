package regex;

import java.util.regex.*;

public class ValidateSSN {

    public static void main(String[] args) {
        String text = "My SSN is 123-45-6789.";

        // Regex to extract SSN
        String regex = "\\b(?!000|666|9\\d\\d)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("No valid SSN found");
        }
    }
}
