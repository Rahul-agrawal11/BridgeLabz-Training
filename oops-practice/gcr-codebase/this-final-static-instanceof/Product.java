class Product {
	
	// Static variable shared across all products
	private static double discount = 10.0;
	
	// Final variable to ensure Product Id number cannot be changed once assigned
	private final String productId;
	private String productName;
	private double price;
	private int quantity;
	
	// Constructor using 'this' to avoid ambiguity
	Product(String productId, String productName, double price, int quantity) {
		this.productId = productId;             // Final variable assigned only once
		this.productName = productName;
		this.price = price;             
		this.quantity = quantity;       
	}
	
	// Static method to modify discount
	public static double updateDiscount() {
		discount += 2.0;
		return discount;
	}
	
	// Static method to display discount
	public static void displayDiscount() {
		System.out.println("Discount: " + discount);
	}
	
	// Static method to calculate price after discount
	public double calculateDiscountedPrice() {
		double discountedPrice = price - ((price * discount) / 100.0);
		return discountedPrice;
	}
	
	// Method to display employee details
	public void displayProductDetails() {
		if(this instanceof Product) {
			System.out.println("Product ID: " + productId);
			System.out.println("Product Name: " + productName);
			System.out.println("Price: $" + price);
			System.out.println("Quantity: " + quantity);
			Product.displayDiscount();
			System.out.println("Price after Discount: " + calculateDiscountedPrice());
		} else {
			System.out.println("Invalid Product instance");
		}
	}
	
	// Getters and setters
	public String getProductName() {
		return productName;
	}
	
	public void setName(String productName) {
		this.productName = productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Main method for testing
	public static void main(String[] args) {
		// Create two employee details
		Product product1 = new Product("P001", "Laptop", 1200.0, 5);
		Product product2 = new Product("P002", "Smartphone", 800.0, 10);
		
		// Display employee details
		product1.displayProductDetails();
		product2.displayProductDetails();
	}	
}