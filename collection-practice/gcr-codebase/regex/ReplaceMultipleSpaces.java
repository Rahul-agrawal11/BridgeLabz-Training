package regex;

public class ReplaceMultipleSpaces {

	public static void main(String[] args) {
		
		String regex = "\\s+";
		String text = "This   is   an  example  with  multiple  spaces.";
		
		String replacedText = text.replaceAll(regex, " ");
		System.out.println("Replaced Text: " + replacedText);

	}

}
