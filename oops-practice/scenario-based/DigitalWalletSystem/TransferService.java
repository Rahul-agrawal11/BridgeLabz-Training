package DigitalWalletSystem;

public interface TransferService {
    void transfer(User from, User to, double amount) throws InsufficientBalanceException;
}
