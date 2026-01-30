package com.junit;

public class ExceptionHandling {
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("b is zero.");
		}
		return a / b;
	}
}
