package scenario.FutureLogistics;

// Concrete class implementing timber-specific transport behavior
public class TimberTransport extends GoodsTransport {
	
	// Timber-specific attributes kept private for data encapsulation
	private float timberLength;
	private float timberRadius;
	private float timberType;
	private float timberPrice;
	
	// Constructor initializes common transport data and timber-related details
	public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
			float timberRadius, float timberType, float timberPrice) {
		super(transportId, transportDate, transportRating);
		this.timberLength = timberLength;
		this.timberRadius = timberRadius;
		this.timberType = timberType;
		this.timberPrice = timberPrice;
	}
	
	public float getTimberLength() {
		return timberLength;
	}
	
	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}
	
	public float getTimberRadius() {
		return timberRadius;
	}
	
	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}
	
	public float getTimberType() {
		return timberType;
	}
	
	public void setTimberType(float timberType) {
		this.timberType = timberType;
	}
	
	public float getTimberPrice() {
		return timberPrice;
	}
	
	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}
	
	// Vehicle selection based on surface area of timber
	// Larger timber requires heavier transport vehicles
	@Override
	public String vehicleSelection() {
	    double area = 2 * Math.PI * timberRadius * timberLength;
	    if (area < 250) return "Truck";
	    else if (area < 400) return "Lorry";
	    return "MonsterLorry";
	}
	
	// Returns vehicle cost according to selected vehicle type
	public double vehiclePrice() {
		String vehiceType = vehicleSelection();
		if (vehiceType.equals("Truck")) {
			return 1000;
		} else if (vehiceType.equals("Lorry")) {
			return 1700;
		}
		return 3000;
	}
	
	// Discount logic based on transport rating
	public double discountPercentage() {
	    if (transportRating == 5) return 20;
	    else if (transportRating == 3 || transportRating == 4) return 10;
	    return 0;
	}
	
	// Calculates total charge using timber volume, price, tax, discount, and vehicle cost
	@Override
	public float calculateTotalCharge() {
		double volume = 3.147 * timberRadius * timberRadius * timberLength;
		double price = volume * timberPrice * timberType;
		double tax = price * 0.3;
		double discount = price * discountPercentage() / 100;
		return (float) ((price + vehiclePrice() + tax) - discount);
	}
	
	// Displays both common and timber-specific transport details
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Type of the timber: " + (timberType == 0.25f ? "Premium" : "NonPremium"));
		System.out.println("Timber price per kilo: " + timberPrice);
		System.out.println("Vehicle for transport: " + vehicleSelection());
		System.out.println("Total charge: " + calculateTotalCharge());
	}
}