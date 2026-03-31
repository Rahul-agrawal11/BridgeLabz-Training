import java.util.ArrayList;
import java.util.List;

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: no direct modification
    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName +
               ", Price: ₹" + price +
               ", Quantity: " + quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();
}

// Veg Item
class VegItem extends FoodItem {

    VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// Non-Veg Item
class NonVegItem extends FoodItem {

    NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        return base + 50; // extra non-veg charge
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5% (Extra charges apply)";
    }
}

// Order Processor (Polymorphism)
class OrderProcessor {

    public static double processOrder(List<FoodItem> items) {

        double finalAmount = 0;

        for (FoodItem item : items) {
            double total = item.calculateTotalPrice();
            double discount = item.applyDiscount();

            finalAmount += (total - discount);

            System.out.println(item.getItemDetails());
            System.out.println("Total: ₹" + total);
            System.out.println("Discount: ₹" + discount);
            System.out.println(item.getDiscountDetails());
            System.out.println("--------------------------------");
        }

        return finalAmount;
    }
}

// Main class
public class OnlineFoodDeliverySystem {

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));

        double payableAmount = OrderProcessor.processOrder(order);

        System.out.println("Final Payable Amount: ₹" + payableAmount);
    }
}
