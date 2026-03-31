class BankAccount {

    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Deposit Method
    public double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        return balance;
    }

    // Withdraw Method (prevents overdraft)
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Check Balance Method
    public double checkBalance() {
        return balance;
    }
}

// Testing BankAccount
class BankAccountTest {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("ACC123", 5000);

        acc.deposit(1500);
        System.out.println("Balance after deposit: " + acc.checkBalance());

        boolean status = acc.withdraw(7000);
        System.out.println("Withdraw successful? " + status);

        acc.withdraw(2000);
        System.out.println("Final Balance: " + acc.checkBalance());
    }
}
