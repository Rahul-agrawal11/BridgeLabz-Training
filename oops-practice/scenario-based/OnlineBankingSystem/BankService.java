package OnlineBankingSystem;

/*
 * INTERFACE: BankService
 * Defines banking operations
 */

public interface BankService {
	void deposit(double amount) throws InsufficientBalanceException;
	
	void withdraw(double amount) throws InsufficientBalanceException;
	
	void checkBalance();
	
	void transfer(Account to, double amount) throws InsufficientBalanceException;

}
