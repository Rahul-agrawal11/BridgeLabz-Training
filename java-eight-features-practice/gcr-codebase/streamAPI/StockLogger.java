package streamAPI;

import java.util.*;

public class StockLogger {
    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(120.5, 121.0, 119.8, 122.3);

        stockPrices.forEach(price -> System.out.println("Stock Price: " + price));
    }
}
