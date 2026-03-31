public class Item {

    // Instance variables (attributes)
    String itemCode;
    double itemPrice;
    String itemName;

    // Constructor to initialize item details
    Item(String itemCode, double itemPrice, String itemName) {
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    // Method to display item details
    void displayItemDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + itemPrice);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {

        // Creating objects
        Item item1 = new Item("01AA", 500.0, "Water bottle");
        Item item2 = new Item("01BB", 700.0, "Rice");
        Item item3 = new Item("02AA", 400.0, "blackboard");

        // Displaying details
        item1.displayItemDetails();
        item2.displayItemDetails();
        item3.displayItemDetails();
    }
}