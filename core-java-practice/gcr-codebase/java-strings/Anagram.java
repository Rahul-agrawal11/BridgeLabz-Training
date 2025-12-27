import java.util.Scanner;

class Anagram {

	public static boolean checkAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[][] freq = countFrequency(str1, str2);
		
		for (int i = 0; i < str1.length(); i++) {
			if (freq[0][i] != freq[1][i]) {
				return false;
			}
		}
		return true;
	}
	
	public static int[][] countFrequency(String str1, String str2) {
		int[] text1Freq = new int[26];
		int[] text2Freq = new int[26];
		
		for (int i = 0; i < str1.length(); i++) {
			text1Freq[str1.charAt(i) - 'a']++;
			text1Freq[str2.charAt(i) - 'a']++;
		}
		return new int[][]{text1Freq, text2Freq};
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter text1: ");
		String str1 = input.next().toLowerCase();
		
		System.out.print("Enter text2: ");
		String str2 = input.next().toLowerCase();

		boolean result = checkAnagram(str1, str2);

		if (result) {
			System.out.println("Both strings are anagram.");
		} else {
			System.out.println("Both strings are not anagram.");
		}
	}
}