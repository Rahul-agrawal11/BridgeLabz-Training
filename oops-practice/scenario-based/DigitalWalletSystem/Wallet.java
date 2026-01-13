package DigitalWalletSystem;

import java.util.ArrayList;

public class Wallet {
    private double balance;
    private ArrayList<Transaction> transactions;

    public Wallet() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("ADD MONEY", amount));
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }

    public void showTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
