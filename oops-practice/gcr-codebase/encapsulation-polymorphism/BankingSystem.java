import java.util.ArrayList;
import java.util.List;

// Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    protected double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: controlled access
    public String getAccountNumber() {
        return "XXXXXX" + accountNumber.substring(accountNumber.length() - 2);
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        return balance;
    }

    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
        return balance;
    }

    // Abstract method
    public abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount {

    SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return balance >= 50000;
    }
}

// Current Account
class CurrentAccount extends BankAccount {

    CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.02; // 2% interest
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return balance >= 100000;
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SB101", "Rahul", 80000));
        accounts.add(new CurrentAccount("CA202", "Amit", 150000));
		
        for (BankAccount acc : accounts) {

            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: ₹" + acc.getBalance());

            double interest = acc.calculateInterest(); // polymorphism
            System.out.println("Calculated Interest: ₹" + interest);

            acc.applyForLoan(50000);
            System.out.println("Loan Eligible: " + acc.calculateLoanEligibility());

            System.out.println("--------------------------------");
        }
    }
}
