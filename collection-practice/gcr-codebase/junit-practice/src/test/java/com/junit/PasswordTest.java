package com.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordTest {
	PasswordValidator pv = new PasswordValidator();
	
	@Test
	void testPassword() {
		assertTrue(pv.checkPassword("Rahul2004"));
	}
	
	@Test
	void testPassword2() {
		assertFalse(pv.checkPassword("@Rahul2004"));
	}
}
