package java_generics.SmartWarehouse;

import java.util.List;

public class Utility {

    public static void displayItems(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            item.getDetails();
            System.out.println("--------------------");
        }
    }
}
