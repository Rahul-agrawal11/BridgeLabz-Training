import java.util.List;
import java.util.ArrayList;

abstract class Product {
	private int productId;
	private String name;
	private double price;
	
	// Constructor
	Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		setPrice(price);
	}
	
	public int getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}	
	
	// Abstract Method
	public abstract double calculateDiscount();
}

public interface Taxable {
	double calculateTax();
	String getTaxDetails();
}

class Electronics extends Product implements Taxable{
	
	Electronics(int productId, String name, double price) {
		super(productId, name, price);
	}
	
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.10;
	}
	
	@Override
	public double calculateTax() {
		return getPrice() * 0.18;
	}
	
	@Override
	public String getTaxDetails() {
		return "18% GST on Electronics";
	}
}

class Clothing extends Product implements Taxable{
	
	Clothing (int productId, String name, double price) {
		super(productId, name, price);
	}
	
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.20;
	}
	
	@Override
	public double calculateTax() {
		return getPrice() * 0.05;
	}
	
	@Override
	public String getTaxDetails() {
		return "5% GST on Clothing";
	}
}

class Groceries extends Product {
	
	Groceries (int productId, String name, double price) {
		super(productId, name, price);
	}
	
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.05;
	}
}

class FinalPriceCalculator {
	public static void printFinalPrices(List<Product> products) {
		for (Product product : products) {
			
			double price = product.getPrice();
			double discount = product.calculateDiscount();
			double tax = 0;
			
			if (product instanceof Taxable) {
				tax = ((Taxable) product).calculateTax();
			}
			
			double finalPrice = price + tax - discount;
			
			System.out.println("Product: " + product.getName());
			System.out.println("Base Price: " + price);
			System.out.println("Discount: " + discount);
			System.out.println("Tax: " + tax);
			System.out.println("Final Price: " + finalPrice);
			System.out.println("----------------------------------");
		}
	}
}

public class ECommercePlatform {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		
		products.add(new Electronics(1001, "Laptop", 65000));
		products.add(new Clothing(1002, "T-Shirt", 1000));
		products.add(new Groceries(1003, "Mustard Oil", 2250));
		
		FinalPriceCalculator.printFinalPrices(products);
	}
}

