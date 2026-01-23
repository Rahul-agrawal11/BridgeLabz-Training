package collections.ShoppingCartSystem;

public class MainShoppingCart {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Add products to store
        cart.addProduct("Laptop", 1200);
        cart.addProduct("Mouse", 25);
        cart.addProduct("Keyboard", 45);
        cart.addProduct("Monitor", 300);

        // Add items to cart
        cart.addToCart("Mouse");
        cart.addToCart("Laptop");
        cart.addToCart("Monitor");
        cart.addToCart("Keyboard");

        // Display cart
        cart.displayCartLinked();
        cart.displayCartByPrice();

        System.out.println("\nTotal Amount: $" + cart.totalAmount());
    }
}

