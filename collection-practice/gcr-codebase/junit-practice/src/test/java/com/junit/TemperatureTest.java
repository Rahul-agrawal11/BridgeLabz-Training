package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TemperatureTest {
	TemperatureConverter tc = new TemperatureConverter();
	
	@Test
	void testCelsius() {
		assertEquals(68, tc.celsiusToFahrenheit(20));
	}
	
	@Test
	void testFahrenheitt() {
		assertEquals(20, tc.fahrenheitToCelsius(68));
	}
}
