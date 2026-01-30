package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {
	
	StringUtils util = new StringUtils();
	
	@Test
	void testReverse() {
		assertEquals("lawarga", util.reverse("agrawal"));
	}
	
	@Test
	void testPalindrome() {
		assertEquals(true, util.isPalindrome("naman"));
	}
	
	@Test
	void testUpperCase() {
		assertEquals("RAHUL", util.convertUpperCase("rahul"));
	}
}
