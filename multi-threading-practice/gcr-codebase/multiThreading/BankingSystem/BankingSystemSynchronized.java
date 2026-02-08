package multiThreading.BankingSystem;

import java.time.LocalDateTime;

class BankAccount1 {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    // synchronized method ensures only 1 thread withdraws at a time
    public synchronized boolean withdraw(String customerName, int amount) {

        if (amount <= balance) {
            // Artificial delay
            try { Thread.sleep(200); } catch (InterruptedException e) {}

            balance = balance - amount;
            return true;
        }
        return false;
    }
}

class Transaction1 implements Runnable {
    private BankAccount1 account;
    private int amount;
    private String customerName;

    public Transaction1(BankAccount1 account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);

        boolean success = account.withdraw(customerName, amount);

        if (success) {
            System.out.println("Transaction successful: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalDateTime.now());
        } else {
            System.out.println("Transaction failed: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalDateTime.now());
        }
    }
}

public class BankingSystemSynchronized {
    public static void main(String[] args) throws InterruptedException {

        BankAccount1 account = new BankAccount1();

        Thread t1 = new Thread(new Transaction1(account, "Customer-1", 3000), "Customer-1");
        Thread t2 = new Thread(new Transaction1(account, "Customer-2", 4000), "Customer-2");
        Thread t3 = new Thread(new Transaction1(account, "Customer-3", 2000), "Customer-3");
        Thread t4 = new Thread(new Transaction1(account, "Customer-4", 5000), "Customer-4");
        Thread t5 = new Thread(new Transaction1(account, "Customer-5", 1500), "Customer-5");

        // Display state before processing
        System.out.println(t1.getName() + " State: " + t1.getState());
        System.out.println(t2.getName() + " State: " + t2.getState());
        System.out.println(t3.getName() + " State: " + t3.getState());
        System.out.println(t4.getName() + " State: " + t4.getState());
        System.out.println(t5.getName() + " State: " + t5.getState());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Main waits for all threads to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("\nFinal Balance = " + account.getBalance());
        System.out.println("All transactions complete!");
    }
}
