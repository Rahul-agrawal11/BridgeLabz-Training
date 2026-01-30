package com.junit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
	
	public boolean writeToFile(String filename, String content) throws FileNotFoundException, IOException {
		try(BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
			br.write(content);
		}
		return true;
	}
	
	public String readFromFile(String filename) throws FileNotFoundException, IOException {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		}
	}
}
