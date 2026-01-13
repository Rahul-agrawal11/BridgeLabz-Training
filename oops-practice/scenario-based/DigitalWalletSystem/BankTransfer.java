package DigitalWalletSystem;

public class BankTransfer implements TransferService {

    @Override
    public void transfer(User from, User to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdrawMoney(amount);
        to.getWallet().addMoney(amount);

        from.getWallet().addTransaction("BANK TRANSFER TO " + to.getName(), amount);
        to.getWallet().addTransaction("BANK RECEIVED FROM " + from.getName(), amount);
    }
}
