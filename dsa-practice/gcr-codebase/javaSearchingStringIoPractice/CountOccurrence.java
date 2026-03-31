package javaSearchingStringIoPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrence {
	
	public static void main(String[] args) {
		
		// Text to find its occurrence
		String text = "times";
		int count = 0;
		
		// Read the file
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\itz_r\\eclipse-workspace\\Sample.txt"))) {
			String line;
			
			while((line = br.readLine()) != null) {
				// Split by space
				String[] words = line.split("\\s+");
			
				for (String word : words) {
					if (word.equalsIgnoreCase(text)) {
						count++;
					}
				}
			}
			
			System.out.println("Occurrence of word "+ text + ": " + count);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
