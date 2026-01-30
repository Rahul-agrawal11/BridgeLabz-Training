package regex;

import java.util.regex.*;

public class ExtractProgrammingLanguage {

	public static void main(String[] args) {
		String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
		String[] languages = {"Java", "Python", "JavaScript", "GO"};
		
		String regex = "(?i)\\b(" + String.join("|", languages) + ")\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			System.out.print(matcher.group() + " ");
		}
	}

}
