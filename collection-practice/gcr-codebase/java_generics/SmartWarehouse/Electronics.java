package java_generics.SmartWarehouse;

public class Electronics extends WarehouseItem{
	private int warrantyYears;
	
	public Electronics(String id, String name, int warrantyYears) {
		super(id, name);
		this.warrantyYears = warrantyYears;
	}
	
	@Override
	public void getDetails() {
		System.out.println("\n--- Electronics Items ---");
		System.out.println("ID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Warranty Years: " + warrantyYears);
	}
}
