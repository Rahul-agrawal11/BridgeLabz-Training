package FlightBookingSystem;

class Booking {
    private String passengerName;
    private Flight flight;

    Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public void displayBooking() {
        System.out.println(
            "Passenger: " + passengerName +
            " | Flight: " + flight.getFlightId() +
            " (" + flight.getSource() + " -> " + flight.getDestination() + ")"
        );
    }
}