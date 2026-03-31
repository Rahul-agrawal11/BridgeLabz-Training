class CartItem {

    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items to cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items from cart
    void removeItem(int qty) {
        if (quantity >= qty) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than present in cart.");
        }
    }

    // Method to display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Total cost: $" + totalCost);
    }
}

public class ShoppingCartSimulation {

    public static void main(String[] args) {

        // Create cart item
        CartItem item = new CartItem("Laptop", 999.99, 1);

        // Display initial item details
        System.out.println("Item: " + item.itemName +
                ", Price: $" + item.price +
                ", Quantity: " + item.quantity);

        // Add items
        item.addItem(2);

        // Remove items
        item.removeItem(1);

        // Display total cost
        item.displayTotalCost();
    }
}
