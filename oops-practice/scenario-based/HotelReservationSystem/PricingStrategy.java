package HotelReservationSystem;

interface PricingStrategy {
	double calculate(double basePrice, int days);
}
