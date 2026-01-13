package OnlineBankingSystem;

import java.util.List;
import java.util.ArrayList;

/*
 * ABSTRACT CLASS: Account
 * Base class for different types of bank accounts
 */

abstract class Account implements BankService{
	private int accountNumber;
	private String holderName;
	protected double balance;
	private List<String> transactions = new ArrayList<>();
	
	Account(int accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	public int getNumber() {
		return accountNumber;
	}
	
	public String getName() {
		return holderName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public List<String> getTransactionHistory() {
        return transactions;
    }
	
	void displayInfo() {
		System.out.println("Account Number: " + accountNumber + "\nAccount Holder Name: " + holderName + "\nTotal Balance: " + balance);
	}
	
	public void deposit(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new InsufficientBalanceException("Deposit amount must be positive.");
		}
		balance += amount;
		transactions.add("Deposited ₹" + amount);
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new InsufficientBalanceException("Withdrawal amount must be positive.");
		}
		if (balance < amount) {
			throw new InsufficientBalanceException("Insufficient Balance.");
		}
		balance -= amount;
		transactions.add("Withdrawn ₹" + amount);
	}

	
	public void checkBalance() {
		System.out.println("Current Balance: " + balance);
	}
	
	/*
     * ABSTRACT METHOD
     * Implemented differently by account types
     */
	abstract double calculateInterest();
	
	/*
	 * Handles fund transfer logic
	 */
	public void transfer(Account to, double amount) throws InsufficientBalanceException {
		this.withdraw(amount);
		to.deposit(amount);

		this.transactions.add("Transferred ₹" + amount + " to A/C " + to.getNumber());
		to.getTransactionHistory()
		  .add("Received ₹" + amount + " from A/C " + this.getNumber());
	}

}
