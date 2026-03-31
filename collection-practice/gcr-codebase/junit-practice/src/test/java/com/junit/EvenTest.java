package com.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenTest {
	
	EvenNumber even = new EvenNumber();
	
	@ParameterizedTest
	@ValueSource(ints = {2, 6, 8, 10})
	void testEvenNumber(int num) {
		assertTrue(even.isEven(num));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 7})
	void testEvenNumber2(int num) {
		assertFalse(even.isEven(num));
	}
}
