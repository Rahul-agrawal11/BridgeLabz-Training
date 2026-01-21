package java_generics.DynamicOnlineMarketplace;

import java.util.Scanner;

public class OnlineMarketPlaceMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Categories
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetsCategory gadgetsCategory = new GadgetsCategory();

        // Products
        Product<BookCategory> book =
                new Product<>("Java Programming", 500.0, bookCategory);

        Product<ClothingCategory> shirt =
                new Product<>("Cotton Shirt", 1200.0, clothingCategory);

        Product<GadgetsCategory> phone =
                new Product<>("Smartphone", 25000.0, gadgetsCategory);

        int choice;

        while (true) {

            System.out.println("\n====== Dynamic Online Marketplace ======");
            System.out.println("1. View All Products");
            System.out.println("2. Apply Discount on Book");
            System.out.println("3. Apply Discount on Clothing");
            System.out.println("4. Apply Discount on Gadget");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Product Details ---");
                    book.getDetails();
                    shirt.getDetails();
                    phone.getDetails();
                    break;

                case 2:
                    System.out.print("Enter discount % for Book: ");
                    Utility.applyDiscount(book, sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter discount % for Clothing: ");
                    Utility.applyDiscount(shirt, sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter discount % for Gadget: ");
                    Utility.applyDiscount(phone, sc.nextInt());
                    break;

                case 5:
                    System.out.println("Thank you for using Online Marketplace!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
