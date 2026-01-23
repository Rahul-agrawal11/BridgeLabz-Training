package collections.BankingSystem;

import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankSystem {

    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    private Queue<WithdrawalRequest> queue = new LinkedList<>();

    // Add new account
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.putIfAbsent(balance, new ArrayList<>());
        sortedByBalance.get(balance).add(accountNumber);
    }

    // Request withdrawal
    public void requestWithdrawal(String accountNumber, double amount) {
        queue.add(new WithdrawalRequest(accountNumber, amount));
    }

    // Process all withdrawals
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!queue.isEmpty()) {
            WithdrawalRequest req = queue.poll();
            double currentBalance = accounts.getOrDefault(req.accountNumber, -1.0);
            if (currentBalance == -1.0) {
                System.out.println("Account not found: " + req.accountNumber);
                continue;
            }
            if (currentBalance >= req.amount) {
                accounts.put(req.accountNumber, currentBalance - req.amount);
                System.out.println("Withdrawal successful: " + req.accountNumber + ", Amount: $" + req.amount);
            } else {
                System.out.println("Insufficient funds: " + req.accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displayAccountsSorted() {
        System.out.println("\nAccounts Sorted by Balance:");
        // Rebuild TreeMap
        sortedByBalance.clear();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            sortedByBalance.putIfAbsent(balance, new ArrayList<>());
            sortedByBalance.get(balance).add(entry.getKey());
        }

        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + " -> $" + entry.getKey());
            }
        }
    }

    // Display all accounts
    public void displayAccounts() {
        System.out.println("\nAccounts (Unordered - HashMap):");
        accounts.forEach((k, v) -> System.out.println(k + " -> $" + v));
    }
}

