package scenario.BankingAccountHierarchy;

// Abstract class for all bank accounts
public abstract class BankAccount {

    // Stores account number
    private final String accountNumber;

    // Stores account balance
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Returns account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Returns account balance
    public double getBalance() {
        return balance;
    }

    // Updates account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Calculates account fee (implemented by subclasses)
    public abstract double calculateFee();

    // Displays account details
    public void displayDetails() {
        System.out.println("===============Account Details===================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Initial Balance: " + balance);
    }
}