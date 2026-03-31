package ExceptionHandling;

import java.util.Scanner;

// Custom Checked Exception
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankTransactionSystem {

    static double balance = 0;

    static void withdraw(double amount) throws InsufficientBalanceException {

        // Negative or zero amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Insufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        // Successful withdrawal
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter initial balance: ");
        balance = input.nextDouble();

        System.out.println("Enter withdrawal amount: ");
        double amount = input.nextDouble();

        try {
            withdraw(amount);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}