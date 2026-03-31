package java_generics.SmartWarehouse;

public class Furniture extends WarehouseItem{
	
	private String material;
	
	public Furniture(String id, String name, String material) {
		super(id, name);
		this.material = material;
	}
	
	@Override
	public void getDetails() {
		System.out.println("\n--- Furniture Items ---");
		System.out.println("ID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Material Type: " + material);
	}

}
