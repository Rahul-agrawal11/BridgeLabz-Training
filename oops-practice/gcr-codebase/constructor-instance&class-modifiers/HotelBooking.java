class HotelBooking {

	// Attributes
    String guestName;
    String roomType;
    int nights;
	
	// Default Constructor
    HotelBooking() {
        guestName = "Rahul";
        roomType = "Standard";
        nights = 1;
    }

	// Parameterized Constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
	
	// Copy Constructor
    HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }
	
	// Display Booking Details
    void displayBooking() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {

		// Default Constructor
        HotelBooking b1 = new HotelBooking();
        System.out.println("Booking 1:");
        b1.displayBooking();

		// Parameterized Constructor
        HotelBooking b2 = new HotelBooking("Amit", "Deluxe", 3);
        System.out.println("\nBooking 2:");
        b2.displayBooking();
		
		// Copy Constructor
        HotelBooking b3 = new HotelBooking(b2);
        System.out.println("\nBooking 3 (Copy):");
        b3.displayBooking();
	}
}