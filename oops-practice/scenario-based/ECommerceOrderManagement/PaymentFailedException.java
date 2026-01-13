package ECommerceOrderManagement;

/*
 * CUSTOM EXCEPTION
 * Thrown when any payment got fail.
 */

public class PaymentFailedException extends Exception{
	PaymentFailedException(String message) {
		super(message);
	}
}
