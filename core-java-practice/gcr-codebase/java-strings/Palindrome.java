import java.util.Scanner;

class Palindrome {
	
	public static boolean toComapreCharacters(String text) {
		int startIndex = 0;
		int endIndex = text.length() - 1;
		
		while (startIndex != endIndex) {
			if (text.charAt(startIndex) != text.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		return true;
	}
	
	public static boolean usingRecursion(String text) {
		int startIndex = 0;
		int endIndex = text.length() - 1;
		
		return isPalindromeByRecursion(text, startIndex, endIndex);
	}
	
	public static boolean isPalindromeByRecursion(String text, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return true;
		}
		
		if (text.charAt(startIndex) != text.charAt(endIndex)) {
			return false;
		}
		
		return isPalindromeByRecursion(text, startIndex + 1, endIndex - 1);
	}
	
	public static boolean usingReverseArray(String text) {
		char[] reverseStr = reverseString(text);
		char[] reverseStrChar = text.toCharArray();
		
		for (int i = 0; i < text.length(); i++) {
			if (reverseStr[i] != reverseStrChar[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static char[] reverseString(String text) {
		int j = 0;
		char[] reverseStr = new char[text.length()];
		for (int i = text.length() - 1; i >= 0; i--) {
			reverseStr[j++] = text.charAt(i);
		}
		return reverseStr;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the text: ");
		String text = input.next();
		
		boolean result1 = toComapreCharacters(text);
		boolean result2 = usingRecursion(text);
		boolean result3 = usingReverseArray(text);
		
		System.out.println("Logic 1 Result: " + result1);
		System.out.println("Logic 2 Result: " + result2);
		System.out.println("Logic 3 Result: " + result3);
	}
}