package FunctionalInterface;

interface PaymentProcessor {

    void pay(double amount); // old method (already exists)

    default void refund(double amount) {
        System.out.println("Refund not supported by this provider: " + amount);
    }
}

class RazorpayProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Razorpay");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " using Razorpay");
    }
}

class PaypalProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
    // refund() not overridden → default refund() will run
}

public class PaymentGatewayIntegration {

    public static void main(String[] args) {

        PaymentProcessor razorpay = new RazorpayProcessor();
        razorpay.pay(5000);
        razorpay.refund(1000);

        PaymentProcessor paypal = new PaypalProcessor();
        paypal.pay(2000);
        paypal.refund(500); // uses default method
    }
}
