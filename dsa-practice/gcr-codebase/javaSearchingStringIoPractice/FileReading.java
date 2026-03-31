package javaSearchingStringIoPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
	
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(
		        new FileReader("C:\\Users\\itz_r\\eclipse-workspace\\Sample.txt"));) {
			
			String line;
			
			StringBuilder content = new StringBuilder();

			while ((line = br.readLine()) != null) {
			    content.append(line).append("\n");
			}

			System.out.println(content.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
