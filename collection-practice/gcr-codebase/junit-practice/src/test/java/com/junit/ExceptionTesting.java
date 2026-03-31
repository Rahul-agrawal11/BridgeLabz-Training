package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionTesting {
	
	ExceptionHandling exce = new ExceptionHandling();
	
	@Test
	void testDivide() {
		assertEquals(2, exce.divide(10, 5));
	}
	
	@Test
	void testDivide1() {
		Exception ex = assertThrows(ArithmeticException.class, () -> exce.divide(10, 0));
		assertEquals("b is zero.", ex.getMessage());
	}	
}
