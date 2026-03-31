package RuntimeAnalysis;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class FileComparison {

	// Reads a file using FileReader (character stream)
	// Measures the time taken to read the entire file character by character
	public static long characterStream(String path) {
		
		// Start time before reading begins
		long startTime = System.nanoTime();
		
		// Try-with-resources ensures FileReader is closed automatically
		try (FileReader fr = new FileReader(path)) {
			int character;
			
			// Read one character at a time until end of file (-1)
			while ((character = fr.read()) != -1) {
				// Reading character (no processing, only timing)
			} 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		// End time after reading finishes
		long endTime = System.nanoTime();
		
		// Return total time taken in nanoseconds
		return endTime - startTime;
	}

	// Reads a file using InputStreamReader (byte stream → character stream)
	// Measures the time taken to read the entire file character by character
	public static long byteStream(String path) {
		
		// Start time before reading begins
		long startTime = System.nanoTime();
		
		// InputStreamReader converts bytes into characters using UTF-8 encoding
		try (InputStreamReader isr =
				new InputStreamReader(new FileInputStream(path), "UTF-8")) {
			
			int character;
			
			// Read one character at a time until end of file (-1)
			while ((character = isr.read()) != -1) {
				// Reading character (no processing, only timing)
			} 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		// End time after reading finishes
		long endTime = System.nanoTime();
		
		// Return total time taken in nanoseconds
		return endTime - startTime;
	}

	public static void main(String[] args) {
		
		// Path of the file to be tested
		String path = "D:\\Users\\itz_r\\Downloads\\100mb-examplefile-com.txt";
		
		// Measure time taken by FileReader
		long characterStrTime = characterStream(path);
		
		// Measure time taken by InputStreamReader
		long byteStrTime = byteStream(path);
		
		// Convert nanoseconds to milliseconds for readability
		System.out.println("Time taken by FileReader: " 
				+ characterStrTime / 1_000_000.0 + " ms");
		
		System.out.println("Time taken by InputStreamReader: " 
				+ byteStrTime / 1_000_000.0 + " ms");
	}
}