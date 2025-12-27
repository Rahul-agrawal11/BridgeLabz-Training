import java.util.Scanner;

class CharactersFrequency {

	public static String[][] freqArray(String text) {
		int[] freq = new int[256];
		
		String[][] charFreq = new String[text.length()][2];
		
		// Count frequency of characters
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			freq[ch]++;
		}
		
		// Assign characters and thier frequencies 
		for (int i = 0; i < charFreq.length; i++) {
			String ch = String.valueOf(text.charAt(i));
			charFreq[i][0] = ch;
			String n = String.valueOf(freq[text.charAt(i)]);
			charFreq[i][1] = n;
		}
		return charFreq;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter string: ");
		String text = input.next();
		
		String[][] charFreq = freqArray(text);
		
		// Display Characters with their Frequencies
		System.out.println("Character\tFrequency");
		for (int i = 0; i < text.length(); i++) {
			System.out.println(charFreq[i][0] + "\t\t" + charFreq[i][1]);
		}
	}
}