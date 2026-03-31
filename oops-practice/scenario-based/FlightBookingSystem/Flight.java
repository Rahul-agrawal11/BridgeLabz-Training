package FlightBookingSystem;

class Flight {
    private int flightId;
    private String source;
    private String destination;
    private int seatsAvailable;

    Flight(int flightId, String source, String destination, int seatsAvailable) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void bookSeat() {
        seatsAvailable--;
    }

    public void display() {
        System.out.println(
            flightId + " | " + source + " -> " + destination +
            " | Seats: " + seatsAvailable
        );
    }
}