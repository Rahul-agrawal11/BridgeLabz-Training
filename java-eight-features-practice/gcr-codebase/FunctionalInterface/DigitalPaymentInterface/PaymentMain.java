package FunctionalInterface.DigitalPaymentInterface;

class UPI implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through UPI....");
	}
}

class CreditCard implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through Credit Card....");
	}
}

class Wallet implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through Wallet....");
	}
}

public class PaymentMain {

	public static void main(String[] args) {
		UPI upi = new UPI();
		upi.pay();
		System.out.print("\n");
		
		CreditCard card = new CreditCard();
		card.pay();
		System.out.print("\n");
		
		Wallet wallet = new Wallet();
		wallet.pay();
		System.out.print("\n");
	}

}
