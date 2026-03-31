package HotelReservationSystem;

public class SeasonalPricing implements PricingStrategy{
	
	private double surgePrice;
	
	SeasonalPricing(double surgePrice) {
		this.surgePrice = surgePrice;
	}
	
	@Override
	public double calculate(double basePrice, int days) {
		return (basePrice * days) * (1 + surgePrice);
	}
}
