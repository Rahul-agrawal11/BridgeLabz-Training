package DigitalWalletSystem;

public class Main {
    public static void main(String[] args) {

        User u1 = new User(1, "Rahul");
        User u2 = new User(2, "Amit");

        try {
            // Add money
            u1.getWallet().addMoney(5000);
            u2.getWallet().addMoney(2000);

            // Withdraw
            u1.getWallet().withdrawMoney(1000);

            // Wallet Transfer
            TransferService walletTransfer = new WalletTransfer();
            walletTransfer.transfer(u1, u2, 1500);

            // Bank Transfer
            TransferService bankTransfer = new BankTransfer();
            bankTransfer.transfer(u2, u1, 500);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        // Transaction History
        System.out.println("\nRahul Transactions:");
        u1.getWallet().showTransactions();

        System.out.println("\nAmit Transactions:");
        u2.getWallet().showTransactions();
    }
}
