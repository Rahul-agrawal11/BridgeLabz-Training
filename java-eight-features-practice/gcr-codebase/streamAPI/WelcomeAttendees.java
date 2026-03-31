package streamAPI;

import java.util.*;

public class WelcomeAttendees {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList("Rahul", "Neha", "Aman");

        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!"));
    }
}
