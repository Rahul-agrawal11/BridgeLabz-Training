package ECommerceOrderManagement;

import java.util.List;
import java.util.ArrayList;

public class Customer {
	private int customerId;
	private String name;
	private List<Order> orders;
	
	Customer(int customerId, String name) {
		this.customerId = customerId;
		this.name = name;
		this.orders = new ArrayList<>();
	}
	
	// Getters
	public int getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
	
	// Add order to customer's order history
	public void addOrder(Order order) {
		if (order != null) {
			orders.add(order);
		}
	}
	
	// View order history
	public void viewOrders() {
		if (orders.isEmpty()) {
			System.out.println("No orders placed yet.");
			return;
		} 
		
		for (Order order : orders) {
			order.displayOrderDetails();
			System.out.println("-----------------------------");
		}
	}
	
	public void displayCustomerDetails() {
		System.out.println("Customer Id: " + customerId);
		System.out.println("Customer Name: " + name);
	}
}
