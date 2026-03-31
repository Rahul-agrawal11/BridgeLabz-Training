package ECommerceOrderManagement;

class Order {
	
	private int orderId;
	private Customer customer;
	private Product product;
	private int quantity;
	private double totalAmount;
	private OrderStatus status;
	private Payment payment;
	
	Order (int orderId, Customer customer, Product product, int quantity, Payment payment) {
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
		this.payment = payment;
		this.status = OrderStatus.PLACED;
	}
	
	// Place order: stock + payment
	public void placeOrder() throws PaymentFailedException {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater than zero.");
		}
		
		boolean stockAvailable = product.reduceStock(quantity);
		if (!stockAvailable) {
			throw new PaymentFailedException("Insufficient stock available.");
		}
		
		totalAmount = product.getPrice() * quantity;
		payment.makePayment(totalAmount);
		
		customer.addOrder(this);
		status = OrderStatus.PLACED;
	}
	
	// Cancel Order
	public void cancelOrder() {
		if (status == OrderStatus.PLACED) {
			product.restoreStock(quantity);
			status = OrderStatus.CANCELLED;
		} else {
			System.out.println("Order cannot be cancelled.");
		}
	}
	
	public void displayOrderDetails() {
        System.out.println("Order ID     : " + orderId);
        System.out.println("Product      : " + product.getName());
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total Amount : ₹" + totalAmount);
        System.out.println("Status       : " + status);
    }

	public int getOrderId() {
		return orderId;
	}
}
