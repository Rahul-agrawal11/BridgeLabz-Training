package FlightBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Array to store flights
    static Flight[] flights = {
        new Flight(101, "Delhi", "Mumbai", 5),
        new Flight(102, "Delhi", "Bangalore", 3),
        new Flight(103, "Mumbai", "Chennai", 4)
    };

    // List to store bookings
    static List<Booking> bookings = new ArrayList<>();

    // Search Flights (case-insensitive)
    static void searchFlights(String source, String destination) {
        boolean found = false;
        for (Flight f : flights) {
            if (f.getSource().equalsIgnoreCase(source) &&
                f.getDestination().equalsIgnoreCase(destination)) {
                f.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    // Book Flight
    static void bookFlight(int flightId, String passengerName) {
        for (Flight f : flights) {
            if (f.getFlightId() == flightId) {
                if (f.getSeatsAvailable() > 0) {
                    f.bookSeat();
                    bookings.add(new Booking(passengerName, f));
                    System.out.println("Booking successful!");
                } else {
                    System.out.println("No seats available.");
                }
                return;
            }
        }
        System.out.println("Invalid Flight ID.");
    }

    // Display Bookings
    static void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        }
        for (Booking b : bookings) {
            b.displayBooking();
        }
    }

    public static void main(String[] args) {

        // SEARCH
        System.out.println("Searching Flights (Delhi to Mumbai):");
        searchFlights("delhi", "MUMBAI");

        // BOOK
        bookFlight(101, "Rahul");
        bookFlight(102, "Amit");

        // DISPLAY BOOKINGS
        System.out.println("\nBooking Details:");
        showBookings();
    }
}