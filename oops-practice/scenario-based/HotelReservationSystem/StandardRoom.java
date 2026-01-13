package HotelReservationSystem;

class StandardRoom extends Room{
	private int days;
	
	StandardRoom(int roomNumber, double pricePerNight, boolean available, PricingStrategy pricingStrategy) {
		super (roomNumber, pricePerNight, available, pricingStrategy);
		this.setDays(days);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	@Override
	public double calculatePrice(int days) {
		return days * getPrice();
	}
}
