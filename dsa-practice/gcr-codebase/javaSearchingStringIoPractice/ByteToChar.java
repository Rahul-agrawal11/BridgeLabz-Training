package javaSearchingStringIoPractice;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class ByteToChar {
	
	public static void main(String[] args) throws IOException {
		
		try {
			
			// FileInputStream object to read the binary data from the file
			FileInputStream fis = new FileInputStream("C:\\Users\\itz_r\\eclipse-workspace\\Sample.txt");
			
			// InputStreamReader to convert the byte stream into a character stream
			InputStreamReader isr = new InputStreamReader(fis);
			
			// BufferedReader to read characters efficiently from the InputStreamReader
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
		} catch (IOException e) {
			System.out.print("Error: " + e.getMessage());
		}
	}
}
