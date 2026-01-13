package OnlineBankingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== ONLINE BANKING SYSTEM =====");
            System.out.println("1. Create New Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Transfer Money");
            System.out.println("7. Calculate Interest");
            System.out.println("8. View Transaction History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    // 1️ CREATE ACCOUNT
                    case 1:
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.println("Select Account Type:");
                        System.out.println("1. Savings Account");
                        System.out.println("2. Current Account");
                        int type = sc.nextInt();

                        Account acc = null;

                        if (type == 1) {
                            acc = new SavingsAccount(accNo, name, bal);
                        } else if (type == 2) {
                            acc = new CurrentAccount(accNo, name, bal);
                        } else {
                            System.out.println("Invalid Account Type!");
                            break;
                        }

                        accounts.add(acc);
                        System.out.println("Account Created Successfully!");
                        break;

                    // 2️ DISPLAY ACCOUNTS
                    case 2:
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts found.");
                        } else {
                            for (Account a : accounts) {
                                a.displayInfo();
                                System.out.println("-------------------");
                            }
                        }
                        break;

                    // 3️ DEPOSIT
                    case 3:
                        Account depAcc = getAccount(sc, accounts);
                        if (depAcc != null) {
                            System.out.print("Enter deposit amount: ");
                            depAcc.deposit(sc.nextDouble());
                            depAcc.checkBalance();
                        }
                        break;

                    // 4️ WITHDRAW
                    case 4:
                        Account wdAcc = getAccount(sc, accounts);
                        if (wdAcc != null) {
                            System.out.print("Enter withdrawal amount: ");
                            wdAcc.withdraw(sc.nextDouble());
                            wdAcc.checkBalance();
                        }
                        break;

                    // 5️ CHECK BALANCE
                    case 5:
                        Account balAcc = getAccount(sc, accounts);
                        if (balAcc != null) {
                            balAcc.checkBalance();
                        }
                        break;

                    // 6️ TRANSFER
                    case 6:
                        System.out.print("Enter FROM Account Number: ");
                        int fromNo = sc.nextInt();
                        System.out.print("Enter TO Account Number: ");
                        int toNo = sc.nextInt();

                        Account fromAcc = findAccount(accounts, fromNo);
                        Account toAcc = findAccount(accounts, toNo);

                        if (fromAcc != null && toAcc != null) {
                            System.out.print("Enter amount to transfer: ");
                            fromAcc.transfer(toAcc, sc.nextDouble());
                            System.out.println("Transfer Successful!");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    // 7️ INTEREST
                    case 7:
                        Account intAcc = getAccount(sc, accounts);
                        if (intAcc != null) {
                            System.out.println("Interest: ₹" + intAcc.calculateInterest());
                        }
                        break;

                    // 8️ TRANSACTION HISTORY
                    case 8:
                        Account hisAcc = getAccount(sc, accounts);
                        if (hisAcc != null) {
                            for (String t : hisAcc.getTransactionHistory()) {
                                System.out.println(t);
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Thank you for using Banking System.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }

    // Helper Methods
    private static Account getAccount(Scanner sc, ArrayList<Account> accounts) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accounts, accNo);
        if (acc == null) {
            System.out.println("Account not found.");
        }
        return acc;
    }

    private static Account findAccount(ArrayList<Account> accounts, int accNo) {
        for (Account a : accounts) {
            if (a.getNumber() == accNo) {
                return a;
            }
        }
        return null;
    }
}