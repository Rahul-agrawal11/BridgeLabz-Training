package HotelReservationSystem;

class RegularPricing implements PricingStrategy{
	
	@Override
	public double calculate(double basePrice, int days) {
		return basePrice * days;
	}
}
