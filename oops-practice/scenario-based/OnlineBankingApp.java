import java.util.ArrayList;
import java.util.List;

/*
 * CUSTOM EXCEPTION
 * Thrown when withdrawal or transfer amount exceeds balance
 */
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

/*
 * ABSTRACT CLASS: Account
 * Base class for different types of bank accounts
 */
abstract class Account {
    private int accountNum;
    private String holderName;
    protected double balance;
    private List<String> transactions = new ArrayList<>();

    Account(int accountNum, String holderName, double balance) {
        this.accountNum = accountNum;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add("Withdrawn: ₹" + amount);
    }

    public List<String> getTransactionHistory() {
        return transactions;
    }

    /*
     * ABSTRACT METHOD
     * Implemented differently by account types
     */
    public abstract double calculateInterest();
}

/*
 * SAVINGS ACCOUNT
 * Provides interest on balance
 */
class SavingsAccount extends Account {

    SavingsAccount(int accountNum, String holderName, double balance) {
        super(accountNum, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }
}

/*
 * CURRENT ACCOUNT
 * No interest calculation
 */
class CurrentAccount extends Account {

    CurrentAccount(int accountNum, String holderName, double balance) {
        super(accountNum, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }
}

/*
 * INTERFACE: BankService
 * Defines banking operations
 */
interface BankService {
    void transfer(Account from, Account to, double amount)
            throws InsufficientBalanceException;
}

/*
 * BANK SERVICE IMPLEMENTATION
 * Handles fund transfer logic
 */
class BankServiceImpl implements BankService {

    @Override
    public void transfer(Account from, Account to, double amount)
            throws InsufficientBalanceException {

        from.withdraw(amount);
        to.deposit(amount);

        from.getTransactionHistory()
            .add("Transferred ₹" + amount + " to A/C " + to.getAccountNum());
        to.getTransactionHistory()
            .add("Received ₹" + amount + " from A/C " + from.getAccountNum());
    }
}

/*
 * RUNNABLE TASK
 * Represents a transaction executed by a thread
 */
class TransactionTask implements Runnable {

    private Account from;
    private Account to;
    private double amount;
    private BankService bankService;

    TransactionTask(Account from, Account to, double amount, BankService bankService) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.bankService = bankService;
    }

    @Override
    public void run() {
        try {
            bankService.transfer(from, to, amount);
            System.out.println(Thread.currentThread().getName()
                    + " transferred ₹" + amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
 * MAIN CLASS
 * Simulates concurrent online banking transactions
 */
class OnlineBankingApp {
    public static void main(String[] args) {

        Account acc1 = new SavingsAccount(101, "Rahul", 5000);
        Account acc2 = new CurrentAccount(102, "Amit", 3000);

        BankService bankService = new BankServiceImpl();

        Thread t1 = new Thread(
                new TransactionTask(acc1, acc2, 2000, bankService),
                "Thread-1"
        );

        Thread t2 = new Thread(
                new TransactionTask(acc1, acc2, 1500, bankService),
                "Thread-2"
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Balances:");
        System.out.println("Rahul: ₹" + acc1.getBalance());
        System.out.println("Amit: ₹" + acc2.getBalance());

        System.out.println("\nRahul Transaction History:");
        for (String t : acc1.getTransactionHistory()) {
            System.out.println(t);
        }
    }
}