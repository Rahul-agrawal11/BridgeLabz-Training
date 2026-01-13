package ECommerceOrderManagement;

public class WalletPayment implements Payment{
	
	public void makePayment(double amount) throws PaymentFailedException {
		System.out.println("Payment of $" + amount + " succeed through card.");
	}
}
