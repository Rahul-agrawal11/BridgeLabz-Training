package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
	BankAccount ba = new BankAccount();
	
	@Test
	void testDeposite() {
		assertEquals("Deposited Successfully!", ba.deposit(1000));
	}
		
	@Test
	void testWithdraw() {
		assertEquals("Deposited Successfully!", ba.deposit(1000));
		assertEquals("Withdraw Successfully!", ba.withdraw(500));
	}
	
	@Test
	void testBalance() {
		assertEquals("Deposited Successfully!", ba.deposit(1000));
		assertEquals(1500, ba.getBalance());
	}
}
