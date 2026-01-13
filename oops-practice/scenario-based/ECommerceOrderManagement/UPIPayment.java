package ECommerceOrderManagement;

public class UPIPayment implements Payment{
	
	public void makePayment(double amount) throws PaymentFailedException {
		System.out.println("Payment of $" + amount + " succeed through card.");
	}
}
