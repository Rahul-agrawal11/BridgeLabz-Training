package scenario.BankingAccountHierarchy;

// Savings account implementation
class SavingsAccount extends BankAccount {

    // Constructor to initialize savings account
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Calculates transaction fee for savings account
    public double calculateFee() {
        return (super.getBalance() / 100.0) * 0.5;
    }

    // Displays savings account details
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Saving Account");
        System.out.println("Transaction Fee: " + calculateFee());
        System.out.println("=================================================");
    }
}
