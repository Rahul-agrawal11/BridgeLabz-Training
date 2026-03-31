package streamAPI;

import java.time.LocalDateTime;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("TX101", "TX102", "TX103");

        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
