package LambdaExpressions;

import java.util.*;

class Product {
    double price;
    int rating;
    int discount;

    public Product(double price, int rating, int discount) {
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
}

public class CustomSortingECommerce {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        List<Product> list = new ArrayList<>();
        list.add(new Product(150.0, 4, 10));
        list.add(new Product(160.0, 2, 12));
        list.add(new Product(170.0, 3, 9));
        list.add(new Product(155.0, 4, 11));
        
        System.out.println("To sort data choose medium(PRICE / RATING / DISCOUNT): ");
        String campaign = sc.next().toUpperCase();

        Comparator<Product> comp = (p1, p2) -> 0; // default

        if (campaign.equals("PRICE")) {
            comp = (p1, p2) -> Double.compare(p1.price, p2.price);
        } 
        else if (campaign.equals("RATING")) {
            comp = (p1, p2) -> Integer.compare(p1.rating, p2.rating);
        } 
        else if (campaign.equals("DISCOUNT")) {
            comp = (p1, p2) -> Integer.compare(p1.discount, p2.discount);
        }

        Collections.sort(list, comp);

        System.out.println("Sorted by: " + campaign);
        System.out.println("Price\tRating\tDiscount");

        for (Product p : list) {
            System.out.println(p.price + "\t" + p.rating + "\t" + p.discount);
        }
        sc.close();
    }
}
