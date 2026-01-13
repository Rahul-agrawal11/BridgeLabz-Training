package OnlineBankingSystem;

/*
 * CUSTOM EXCEPTION
 * Thrown when withdrawal or transfer amount exceeds balance
 */

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}