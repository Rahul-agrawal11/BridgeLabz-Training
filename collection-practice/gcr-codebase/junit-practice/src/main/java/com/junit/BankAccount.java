package com.junit;

public class BankAccount {
	
	static double balance = 500;
	
	public String deposit(double amount) {
		if (amount > 0) {
			balance+=amount;
			return "Deposited Successfully!";
		}
		return "Amount must be positive.";
	}
	
	public String withdraw(double amount) {
		if (amount <= balance) {
			balance-=amount;
			return "Withdraw Successfully!";
		}
		return "Funds are insufficient";
	}
	
	public double getBalance() {
		return balance;
	}
}
