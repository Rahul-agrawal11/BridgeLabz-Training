package ECommerceOrderManagement;

/*
 * INTERFACE: Payment
 * Defines Payment Type Like Card/UPI/Wallet
 */

interface Payment {
	void makePayment(double amount) throws PaymentFailedException;
}
