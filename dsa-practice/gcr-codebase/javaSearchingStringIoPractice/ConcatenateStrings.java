package javaSearchingStringIoPractice;

public class ConcatenateStrings {
	
	// Method to concatenation of strings 
	public static String concatenation(String[] words) {
		StringBuffer sb = new StringBuffer();
		
		for (String word : words) {
			sb.append(word);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String[] words = {"I", " am", " Rahul"," Agrawal."};
		
        String concateString = ConcatenateStrings.concatenation(words);

        System.out.println("Concatenated String: " + concateString);

	}
}
