package DigitalWalletSystem;

public class WalletTransfer implements TransferService {

    @Override
    public void transfer(User from, User to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdrawMoney(amount);
        to.getWallet().addMoney(amount);

        from.getWallet().addTransaction("TRANSFER TO " + to.getName(), amount);
        to.getWallet().addTransaction("RECEIVED FROM " + from.getName(), amount);
    }
}
