package streamAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return name + " Expiry: " + expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("Rahul", LocalDate.now().plusDays(10)),
                new Member("Aman", LocalDate.now().plusDays(40)),
                new Member("Neha", LocalDate.now().plusDays(25)),
                new Member("Priya", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<Member> expiringSoon = members.stream()
                .filter(m -> !m.getExpiryDate().isBefore(today)) 
                .filter(m -> !m.getExpiryDate().isAfter(next30Days)) 
                .collect(Collectors.toList());

        expiringSoon.forEach(System.out::println);
    }
}
