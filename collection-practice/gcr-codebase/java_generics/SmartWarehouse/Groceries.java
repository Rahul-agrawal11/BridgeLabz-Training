package java_generics.SmartWarehouse;

public class Groceries extends WarehouseItem{
	private String expiryDate;
	
	public Groceries(String id, String name, String expiryDate) {
		super(id, name);
		this.expiryDate = expiryDate;
	}
	
	@Override
	public void getDetails() {
		System.out.println("\n--- Grocery Items ---");
		System.out.println("ID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Expiry Date: " + expiryDate);
	}
}
