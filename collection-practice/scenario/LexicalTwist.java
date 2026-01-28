package scenario;

import java.util.Scanner;

public class LexicalTwist {
	
	// Method to check whether word2 is reverse of word1 or not
	public static boolean checkRev(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}
		int indexWord1 = 0;
		int indexWord2 = word2.length() - 1;
		while (indexWord1 < word1.length() && indexWord2 >= 0) {
			if (word1.charAt(indexWord1) != word2.charAt(indexWord2)) {
				return false;
			}
			indexWord1++;
			indexWord2--;
		}
		return true;
	}
	
	public static void replacingVowels(String word1, String word2) {
		// Check if word2 is reverse of word1
		boolean isReverse = checkRev(word1, word2);
		
		// If true, 
		if(isReverse) {
			StringBuilder sb = new StringBuilder(word1);
			// First reverse the word
			sb.reverse();
			// Replace the vowels with @ and convert the word in lowercase
			String transformedWord = String.valueOf(sb).replaceAll("[aeiou]", "@").toLowerCase();
			// Print the transfored word
			System.out.println(transformedWord);
			return;
		}
		// Otherwise
		printVowelOrConsonant(word1, word2);
	}
	
	// Method to concate both the words and convert them into uppercase
	public static String concatenation(String word1, String word2) {
		return word1.concat(word2).toUpperCase();
	}
	
	// Method to separate vowels and consonants
	public static String[] storeAlphabets(String word1, String word2) {
		// Concate the words
		String combinedStr = concatenation(word1, word2);
		
		String vowels = "";
		String consonants = "";
		for (int i = 0; i < combinedStr.length(); i++) {
			if (combinedStr.charAt(i) == 'A' || combinedStr.charAt(i) == 'E' || combinedStr.charAt(i) == 'I' || combinedStr.charAt(i) == 'O' || combinedStr.charAt(i) == 'U') {
				// add vowels into vowel string
				vowels += combinedStr.charAt(i);				
			} else {
				// add consonants into consonant string
				consonants += combinedStr.charAt(i);
			}
		}
		return new String[] {vowels, consonants};
	}
	
	// If both words are different 
	public static void printVowelOrConsonant(String word1, String word2) {
		// Stores vowel and consonant string
		String[] result = storeAlphabets(word1, word2);

		// If length of both is equal
		if (result[0].length() == (result[1].length())) {
			// If there are more vowels then print first two vowels
			System.out.println("Vowels and consonants are equal");

		} else if (result[0].length() > result[1].length()) {
			// If there are more vowels then print first two unique vowels
			System.out.print(result[0].charAt(0) + "" + removeDuplicates(result[0]));
			
		} else {
			// If there are more consonants then print first two unique consonants
			System.out.print(result[1].charAt(0) + "" + removeDuplicates(result[1]));
		}
	}
	
	// Remove duplicate character
	public static char removeDuplicates(String word) {
		for (int i = 1; i < word.length() - 1; i++) {
			if (word.charAt(i) != word.charAt(i-1))   {
				return word.charAt(i);
			}
		}
		return ' ';
	}
	
	public static void main(String[] args) {
		try {
			// Create scanner class object
			Scanner input = new Scanner(System.in);
			
			// User input for first word
			System.out.println("Enter the first word: ");
			String word1 = input.next().toLowerCase();
			// Store input buffer elements
			String leftover1 = input.nextLine().trim();
			
			// If user enters more than one word so in this case we check for input buffer
			if(!leftover1.isEmpty()) {
				input.close();
				throw new Exception(word1 + " " + leftover1 + " is an invalid word.");
			}
			
			// User input for second word
			System.out.println("Enter the second word: ");
			String word2 = input.next().toLowerCase();
			// Store input buffer elements
			String leftover2 = input.nextLine().trim();
			
			// If user enters more than one word so in this case we check for input buffer
			if(!leftover2.isEmpty()) {
				input.close();
				throw new Exception(word2 + " " + leftover2 + " is an invalid word.");
			}
			
			// Method call
			replacingVowels(word1.trim(), word2.trim());
			
			// Close input
			input.close();
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
