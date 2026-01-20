package scenario.BankingAccountHierarchy;

// Checking account implementation
public class CheckingAccount extends BankAccount {

    // Constructor to initialize checking account
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Calculates transaction fee for checking account
    public double calculateFee() {
        if (super.getBalance() > 1000) {
            return 0;
        }
        return 1.0;
    }

    // Displays checking account details
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Checking Account");
        System.out.println("Transaction Fee: " + calculateFee());
        System.out.println("=================================================");
    }
}