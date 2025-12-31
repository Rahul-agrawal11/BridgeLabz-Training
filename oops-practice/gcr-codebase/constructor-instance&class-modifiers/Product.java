class Product {

	// Instance Variables
	String productName; 
	double price;
	
	// Class Variable
	static int totalProducts;
	
	// Constructor
	Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
		totalProducts++;
	}
	
	// Instance Method
	void displayProductDetails() {
		System.out.println("Product Name: " + productName);
		System.out.println("Product Price: " + price);
	}
	
	// Class Method
	static void displayTotalProducts() {
		System.out.println("Total Products: " + totalProducts);
	}
	
	public static void main(String[] args) {
		Product product1 = new Product("Office Chair", 1500);
		Product product2 = new Product("Printer", 5000);
		
		product1.displayProductDetails();
		product2.displayProductDetails();
		
		Product.displayTotalProducts();
		
	}
}