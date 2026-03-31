package ECommerceOrderManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Product> products = new ArrayList<>();
		ArrayList<Customer> customers = new ArrayList<>();
		ArrayList<Order> orders = new ArrayList<>();
		
		int choice;
		
		do {
			System.out.println("\n===== E-COMMERCE ORDER MANAGEMENT =====");
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. Add Customer");
			System.out.println("4. Place Order");
			System.out.println("5. Cancel Order");
			System.out.println("6. View Customer Orders");
			System.out.println("0. Exit");
			System.out.println("Enter Choice: ");
			
			choice = sc.nextInt();
			
			try {
				switch(choice) {
				
					// Add Product
					case 1:
						System.out.println("Enter Product Id: ");
						int pid = sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter Product name: ");
						String pname = sc.nextLine();
						sc.nextLine();
						
						System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Stock Quantity: ");
                        int stock = sc.nextInt();
                        
                        products.add(new Product(pid, pname, price, stock));
                        break;
                       
                     // View Products
					case 2:
						if (products.isEmpty()) {
							System.out.println("No product available.");
						} else {
							for (Product p : products) {
								p.displayProductDetails();
								System.out.println("---------------------------------");
							}
						}
						break;
					
					// Add Customer
					case 3: 
						System.out.print("Customer ID: ");
                        int cid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Customer Name: ");
                        String cname = sc.nextLine();

                        customers.add(new Customer(cid, cname));
                        System.out.println("Customer added successfully.");
                        break;
                     
                    // Place Order
					case 4:
						Customer customer = findCustomer(sc, customers);
						Product product = findProduct(sc, products);
						
						if (customer == null || product == null) break;
						
						System.out.print("Quantity: ");
                        int qty = sc.nextInt();

                        System.out.println("Payment Method:");
                        System.out.println("1. Card");
                        System.out.println("2. UPI");
                        System.out.println("3. Wallet");
                        int payChoice = sc.nextInt();
                        
                        Payment payment;
                        if (payChoice == 1) {
                        	payment = new CardPayment();
                        } 
                        else if (payChoice == 2) {
                        	payment = new UPIPayment();
                        }
                        else {
                        	payment = new WalletPayment();
                        } 
                        
                        
                        Order order = new Order(orders.size() + 1, customer, product, qty, payment);
                        order.placeOrder();
                        orders.add(order);
                        System.out.println("Order placed successfully.");
                        break;
                        
                    // Cancel Order
					case 5: 
						System.out.print("Enter Order ID: ");
                        int oid = sc.nextInt();
                        
                        Order ord = findOrder(orders, oid);
                        
                        if (ord != null) {
                        	ord.cancelOrder();
                        } else {
                        	System.out.println("Order not found.");
                        }
                        break;
                        
                    // View Customer Orders
					case 6:
						Customer cust = findCustomer(sc, customers);
						if (cust != null) {
							cust.viewOrders();
						}
						break;
					
					// Exit
					case 0:
						System.out.println("Thank you for using the system.");
                        break;
                        
                    default:
                    	System.out.println("Invalid choice.");
				}
			} catch (PaymentFailedException e) {
				System.out.println("Payment Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (choice != 0);
		sc.close();
	}
	
	private static Product findProduct(Scanner sc, ArrayList<Product> products) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        for (Product p : products) {
            if (p.getProductId() == id) return p;
        }
        System.out.println("Product not found.");
        return null;
    }
	
	private static Customer findCustomer(Scanner sc, ArrayList<Customer> customers) {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        for (Customer c : customers) {
            if (c.getCustomerId() == id) return c;
        }
        System.out.println("Customer not found.");
        return null;
    }
	
	private static Order findOrder(ArrayList<Order> orders, int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) return o;
        }
        return null;
    }
}