package java_generics.DynamicOnlineMarketplace;

public class Product<T extends Category>{
	
	T category;
	
	private String name;
	private double price;
	
	public Product(String name, double price, T category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void getDetails() {
		System.out.println("Category: " + category.getCategoryName());
		System.out.println("Product Name: " + name);
		System.out.println("Product Price: " + price);
	}
}
