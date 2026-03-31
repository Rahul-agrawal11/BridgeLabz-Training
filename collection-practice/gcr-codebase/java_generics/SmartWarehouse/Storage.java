package java_generics.SmartWarehouse;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
	
	private List<T> items = new ArrayList<>();
	
	public boolean addItem(T item) {
		return items.add(item);
	}
	
	public List<T> getItems() {
		return items;
	}
}
  