class BankAccount {

    // Public member
    public long accountNumber;

    // Protected member
    protected String accountHolder;

    // Private member
    private double balance;

    // Constructor
    BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Public method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount");
            return false;
        }
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);     // public
        System.out.println("Account Holder: " + accountHolder);     // protected
        System.out.println("Balance: " + getBalance());             // private via getter
    }

    public static void main(String[] args) {

        SavingsAccount savings =
                new SavingsAccount(9876543210L, "Rahul Agrawal", 5000.0);

        savings.displayAccountDetails();

        savings.deposit(2000);
        savings.withdraw(1500);

        System.out.println("Updated Balance: " + savings.getBalance());
    }
}
