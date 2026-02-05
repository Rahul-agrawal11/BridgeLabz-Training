package streamAPI;

import java.util.*;

public class CustomerNames {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("rahul", "neha", "aman", "priya");

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}