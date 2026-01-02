import java.util.Scanner;

public class AnagramString {
	
	public static boolean checkAnagram(String text1, String text2) {
		char[] freq1 = new char[26];
		char[] freq2 = new char[26];
		
		for (int i = 0; i < text1.length(); i++) {
			freq1[text1.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < text2.length(); i++) {
			freq2[text2.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < freq1.length; i++) {
			if (freq1[i] != freq2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		// Taking user input
		Scanner input = new Scanner(System.in);
		
		// First String 
		System.out.print("Enter First String: ");
		String text1 = input.next();
			
		// Second String 
		System.out.print("Enter First String: ");
		String text2 = input.next();
		
		boolean isAnagram = checkAnagram(text1, text2);
		
		if (isAnagram) {
			System.out.println("Strings are anagram.");
		} else {
			System.out.println("Strings are not anagram.");
		}
	}
}