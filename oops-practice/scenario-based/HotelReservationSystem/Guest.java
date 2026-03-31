package HotelReservationSystem;

class Guest {
	
	private int guestId;
	private String name;
	
	Guest(int guestId, String name) {
		this.guestId = guestId;
		this.name = name;
	}
	
	public int getId() {
		return guestId;
	}
	
	public String getName() {
		return name;
	}
	
	public void displayGuestDetails() {
		System.out.println("Guest Id: " + guestId);
		System.out.println("Guest Name: " + name);
	}
}
