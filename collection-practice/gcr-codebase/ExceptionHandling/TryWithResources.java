package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) throws IOException {
		
		// try-with-resources: BufferedReader will be automatically closed
		try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
			
			String line = br.readLine(); // read only first line
		    System.out.println(line);
		
		} 
		// Catch IOException if file not found or reading error occurs
		catch (IOException e) {
			System.out.println("Error reading file");
		}
	}

}
