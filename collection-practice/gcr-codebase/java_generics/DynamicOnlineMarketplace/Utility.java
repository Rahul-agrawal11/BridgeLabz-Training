package java_generics.DynamicOnlineMarketplace;

public class Utility {

    public static void applyDiscount(Product<? extends Category> product, double discount) {
        double discountAmount = (product.getPrice() * discount) / 100;
        product.setPrice(product.getPrice() - discountAmount);

        System.out.println("Discount Applied: " + discount + "%");
        System.out.println("Final Price: " + product.getPrice());
    }
}
