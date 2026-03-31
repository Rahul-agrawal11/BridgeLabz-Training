package collections.ShoppingCartSystem;

import java.util.*;

public class ShoppingCart {

    // HashMap: product prices
    private Map<String, Double> productPrices = new HashMap<>();

    // LinkedHashMap: maintain order of items added
    private Map<String, Double> cart = new LinkedHashMap<>();

    // TreeMap: sorted by price
    private TreeMap<Double, List<String>> priceSortedMap = new TreeMap<>();

    // Add product to store
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not available: " + product);
            return;
        }
        double price = productPrices.get(product);
        cart.put(product, price);

        priceSortedMap.putIfAbsent(price, new ArrayList<>());
        priceSortedMap.get(price).add(product);
    }

    // Display cart items in insertion order
    public void displayCartLinked() {
        System.out.println("\nCart Items (Insertion Order):");
        cart.forEach((k, v) -> System.out.println(k + " -> $" + v));
    }

    // Display cart items sorted by price
    public void displayCartByPrice() {
        System.out.println("\nCart Items (Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : priceSortedMap.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " -> $" + entry.getKey());
            }
        }
    }

    // Total cart value
    public double totalAmount() {
        return cart.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

