package HotelReservationSystem;

class Reservation {
	private static int counter = 1;
	
	private int reservationId;
	private Room room;
	private Guest guest;
	private int days;
	private boolean checkedIn;
	private boolean checkedOut;
	
	Reservation(Guest guest, Room room, int days) {
		this.reservationId = counter++;
		this.guest = guest;
		this.room = room;
		this.days = days;
		this.checkedIn = false;
		this.checkedOut = false;
	}
	
	// Getter
	public int getReservationId() {
		return reservationId;
	}
	// Book Room
	public void bookRoom() throws RoomNotAvailableException {
		if (!room.checkAvailability()) {
			throw new RoomNotAvailableException("Room is already booked.");
		}
		room.bookRoom();
	}
	
	// Check-In
	public void checkIn() {
		if (!checkedIn) {
			checkedIn = true;
			System.out.println("Room checked in successfully.");
		} else {
			System.out.println("Room already checked in.");
		}
	}
	
	// Check-Out
	public void checkOut() {
		if (!checkedOut) {
			checkedOut = true;
			room.vacateRoom();
			generateInvoice();
		} else {
			System.out.println("Guest already checked out.");
		}
	}
	
	// Calculate Bill
	public double calculateBill() {
		return room.calculatePrice(days);
	}
	
	// Invoice
    public void generateInvoice() {
        System.out.println("\n----- INVOICE -----");
        System.out.println("Reservation ID: " + reservationId);
        guest.displayGuestDetails();
        room.displayRoomDetails();
        System.out.println("Total Days: " + days);
        System.out.println("Total Amount: ₹" + calculateBill());
        System.out.println("-------------------\n");
    }
    
    // Display reservation
    public void displayReservationDetails() {
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.getRoomNum());
        System.out.println("Days: " + days);
        System.out.println("Checked In: " + checkedIn);
        System.out.println("Checked Out: " + checkedOut);
    }
}
