package collections.BankingSystem;

public class MainBankingSystem {
    public static void main(String[] args) {

        BankSystem bank = new BankSystem();

        // Add accounts
        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 3000);
        bank.addAccount("A103", 7000);

        // Display unordered accounts
        bank.displayAccounts();

        // Request withdrawals
        bank.requestWithdrawal("A101", 2000);
        bank.requestWithdrawal("A102", 4000);
        bank.requestWithdrawal("A103", 1000);

        // Process withdrawals
        bank.processWithdrawals();

        // Display accounts sorted by balance
        bank.displayAccountsSorted();
    }
}

