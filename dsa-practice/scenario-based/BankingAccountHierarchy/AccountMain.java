package scenario.BankingAccountHierarchy;

// Main class to test bank account hierarchy
public class AccountMain {

    // Program execution starts here
    public static void main(String[] args) {

        // Create savings account
        BankAccount savings = new SavingsAccount("101", 500);
        savings.displayDetails();
        System.out.printf("%.2f%n", savings.calculateFee());

        // Create checking account with high balance
        BankAccount checking1 = new CheckingAccount("102", 1500);
        checking1.displayDetails();

        // Create checking account with low balance
        BankAccount checking2 = new CheckingAccount("103", 500);
        checking2.displayDetails();
    }
}