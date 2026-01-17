package javaSearchingStringIoPractice;

import java.util.Scanner;
import java.io.*;

public class SearchForWord {
	
	// Method to find the sentence which contains the specific word 
	public static String searchForSpecificWord(String text, String word) throws IOException{
		
		try (BufferedReader br = new BufferedReader(new FileReader(text))) {
			
			String line;
			// Read line by line
			while ((line = br.readLine()) != null) {
				// If line contain word it returns the sentence
				if (line.contains(word)) {
					return line;
				}
			}
		}
		// If not found return "Not found"
		return "Not found";
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter word to find: ");
		String word = input.next();
		
		// Path of the file
		String path = "C:\\Users\\itz_r\\eclipse-workspace\\Sample.txt";
		
		String sentence = SearchForWord.searchForSpecificWord(path, word);
		System.out.println("Sentence: " + sentence);
		input.close();
	}
}
