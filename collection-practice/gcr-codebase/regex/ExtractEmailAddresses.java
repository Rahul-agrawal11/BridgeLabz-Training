package regex;

import java.util.regex.*;

public class ExtractEmailAddresses {
	
    public static void main(String[] args) {
    	
        // Removed the start (^) and end ($) anchors
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String text = "Contact us at support@example.com and info@company.org";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            // This will now successfully print the email addresses found
            System.out.println(matcher.group()); 
        }
    }
}
