class MovieTicket {

    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    // Constructor
    MovieTicket() {
        isBooked = false;
    }

    // Method to book ticket
    void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display ticket details
    void displayTicketDetails() {
        if (isBooked) {
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }
}

public class MovieTicketBookingSystem {

    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        // Ticket not booked yet
        ticket.displayTicketDetails();

        // Booking ticket
        ticket.bookTicket("Dragon", "A10", 120.0);

        // Trying to book again
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);

        // Display ticket details
        ticket.displayTicketDetails();
    }
}
