// Super Class 
class Order {
	String orderId;
	String orderDate;
	
	Order(String orderId, String orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	
	// Method to return order status
	String getOrderStatus() {
		return "Order Confirmed.";
	}
}

// Subclass of Order 
class ShippedOrder extends Order {
	int trackingNumber;
	
	ShippedOrder(String orderId, String orderDate, int trackingNumber) {
		super(orderId, orderDate);
		this.trackingNumber = trackingNumber;
	}
	
	// Method to return shipped order status
	String getOrderStatus() {
		return "Order Shipped.";
	}
}

// Subclass of ShippedOrder
class DeliveredOrder extends ShippedOrder {
	String deliveryDate;
	
	DeliveredOrder(String orderId, String orderDate, int trackingNumber, String deliveryDate) {
		super(orderId, orderDate, trackingNumber);
		this.deliveryDate = deliveryDate;
	}
	
	// Method to return delivered order status
	String getOrderStatus() {
		return "Order Delivered.";
	}
}

// Main Class 
public class OnlineRetailOrderManagement {
	public static void main(String[] args) {
		
		Order order = new Order("O001", "02-01-2026");
		ShippedOrder shippedOrder = new ShippedOrder("O001", "02-01-2026", 456789);
		DeliveredOrder deliveredOrder = new DeliveredOrder("O001", "02-01-2026", 456789, "04-01-2026");
		
		System.out.println("Order Status: " + order.getOrderStatus());
		System.out.println("Shipped Status: " + shippedOrder.getOrderStatus());
		System.out.println("Delivered Status: " + deliveredOrder.getOrderStatus());
	}
}
