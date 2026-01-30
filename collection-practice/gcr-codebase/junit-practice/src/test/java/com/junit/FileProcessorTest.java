package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileProcessorTest {
	
	FileProcessor p = new FileProcessor();
	
	@Test
	void testWriter() throws FileNotFoundException, IOException {
		assertEquals(true, p.writeToFile("Sample.txt", "Rahul"));
	}
	
	@Test
	void testReader() throws FileNotFoundException, IOException {
		assertEquals("Rahul", p.readFromFile("Sample.txt"));
	}
}
