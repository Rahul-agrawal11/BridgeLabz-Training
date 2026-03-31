public class BankAccount {

    // Method to deposit money
    static double depositMoney(double balance, double amount) {
        System.out.println("Deposited: " + amount);
        return balance + amount;
    }

    // Method to withdraw money
    static double withdrawMoney(double balance, double amount) {
        if (balance >= amount) {
            System.out.println("Withdraw amount is : " + amount);
            return balance - amount;
        } else {
            System.out.println("Insufficient balance");
            return balance;
        }
    }

    // Method to display balance
    static void displayBalance(double balance) {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {

        String accountHolder = "Rahul";
        int accountNumber = 12345;
        double balance = 700.0;

        // Display initial balance
        displayBalance(balance);

        // Deposit money
        balance = depositMoney(balance, 200.0);
        displayBalance(balance);

        // Withdraw money
        balance = withdrawMoney(balance, 100.0);
        displayBalance(balance);

        // Withdraw more than balance
        balance = withdrawMoney(balance, 1000.0);
    }
}
