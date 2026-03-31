package ECommerceOrderManagement;

public class CardPayment implements Payment{
	
	public void makePayment(double amount) throws PaymentFailedException  {
		System.out.println("Payment of $" + amount + " succeed through card.");
	}
}
