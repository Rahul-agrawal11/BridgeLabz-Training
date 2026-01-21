package java_generics.SmartWarehouse;

import java.util.Scanner;

public class SmartWarehouseMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        // Storage units
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();

        while (true) {

            System.out.println("\n====== Smart Warehouse Management System ======");
            System.out.println("1. Add Electronics Item");
            System.out.println("2. Add Furniture Item");
            System.out.println("3. Add Grocery Item");
            System.out.println("4. Display All Items");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    electronicsStorage.addItem(
                        new Electronics("E101", "Laptop", 2)
                    );
                    electronicsStorage.addItem(
                        new Electronics("E102", "Mobile", 1)
                    );
                    System.out.println("Electronics items added");
                    break;

                case 2:
                    furnitureStorage.addItem(
                        new Furniture("F201", "Chair", "Wood")
                    );
                    furnitureStorage.addItem(
                        new Furniture("F202", "Table", "Metal")
                    );
                    System.out.println("Furniture items added");
                    break;

                case 3:
                    groceriesStorage.addItem(
                        new Groceries("G301", "Milk", "2026-02-10")
                    );
                    groceriesStorage.addItem(
                        new Groceries("G302", "Rice", "2026-06-01")
                    );
                    System.out.println("Grocery items added");
                    break;

                case 4:                
                    Utility.displayItems(electronicsStorage.getItems());
  
                    Utility.displayItems(furnitureStorage.getItems());

                    Utility.displayItems(groceriesStorage.getItems());
                    break;

                case 5:
                    System.out.println("Exiting Smart Warehouse System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
