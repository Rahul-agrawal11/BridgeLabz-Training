package OnlineBankingSystem;

/*
 * CURRENT ACCOUNT
 * No interest calculation
 */

public class CurrentAccount extends Account {
	
	CurrentAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}
	
	@Override
	public double calculateInterest() {
		return 0;
	}
}
