package HotelReservationSystem;

abstract class Room {
	private int roomNumber;
	private double pricePerNight;
	private boolean available;
	private PricingStrategy pricingStrategy;
	
	Room (int roomNumber, double pricePerNight, boolean available, PricingStrategy pricingStrategy) {
		this.roomNumber = roomNumber;
		this.pricePerNight = pricePerNight;
		this.available = available;
		this.pricingStrategy = pricingStrategy;
	}
	
	// Getters
	public int getRoomNum() {
		return roomNumber;
	}
	
	public double getPrice() {
		return pricePerNight;
	}
	
	public boolean checkAvailability() {
		return available;
	}
	
	public void bookRoom() throws RoomNotAvailableException{
		if (!available) {
            throw new RoomNotAvailableException("Room " + roomNumber + " is already booked!");
        }
        available = false;
        System.out.println("Room booked successfully!");
	}
	
	public void vacateRoom() {
		available = true;
		System.out.println("Room is now available.");
	}
	
	public void displayRoomDetails() {
		System.out.println("Room Number: " + roomNumber);
		System.out.println("Price per night: " + pricePerNight);
		System.out.println("Available: " + available);
	}
	
	public double calculatePrice(int days) {
        return pricingStrategy.calculate(pricePerNight, days);
    }
}