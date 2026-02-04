package FunctionalInterface;

interface SensitiveData {
    // Marker interface (no methods)
}

class BankAccount implements SensitiveData {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class SecurityProcessor {

    public static String secureToString(Object obj) {

        if (obj instanceof SensitiveData) {
            return "ENCRYPTED_DATA";
        }

        return obj.toString();
    }
}

public class SensitiveDataTagging {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("1234567890", 50000);

        System.out.println(SecurityProcessor.secureToString(acc));
    }
}
