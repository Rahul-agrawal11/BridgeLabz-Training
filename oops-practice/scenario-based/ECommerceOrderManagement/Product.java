package ECommerceOrderManagement;

public class Product {

    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(int productId, String name, double price, int stockQuantity) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Update price with validation
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price;
    }

    // Reduce stock when order is placed
    public boolean reduceStock(int quantity) {
        if (quantity <= 0) {
            return false;
        }

        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            return true;
        }

        return false; // insufficient stock
    }

    // Restore stock when order is cancelled
    public void restoreStock(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
        }
    }

    // Display product details
    public void displayProductDetails() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + name);
        System.out.println("Price        : ₹" + price);
        System.out.println("Stock        : " + stockQuantity);
    }
}