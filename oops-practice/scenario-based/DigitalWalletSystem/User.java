package DigitalWalletSystem;

public class User {
    private int userId;
    private String name;
    private Wallet wallet;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }
}
