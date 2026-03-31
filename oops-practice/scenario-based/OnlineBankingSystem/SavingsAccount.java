package OnlineBankingSystem;

/*
 * SAVINGS ACCOUNT
 * Provides interest on balance
 */

class SavingsAccount extends Account{
	
	SavingsAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}
	
	@Override
	public double calculateInterest() {
		return getBalance() * 0.04;
	}
}
