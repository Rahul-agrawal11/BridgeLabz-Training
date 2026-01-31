package scenario.FutureLogistics;

// Concrete class representing brick-specific transport logic
public class BrickTransport extends GoodsTransport {
	
	// Brick-specific attributes kept private to maintain encapsulation
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;
	
	// Constructor initializes both common transport details and brick-specific data
	// super() is used to reuse initialization logic from the parent class
	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
			int brickQuantity, float brickPrice) {
		super(transportId, transportDate, transportRating);
		this.brickSize = brickSize;
		this.brickQuantity = brickQuantity;
		this.brickPrice = brickPrice;
	}
	
	public float getBrickSize() {
		return brickSize;
	}

	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}

	public int getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public float getBrickPrice() {
		return brickPrice;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}

	// Vehicle selection logic based on quantity of bricks
	// Ensures optimal vehicle usage depending on load size
	@Override
	public String vehicleSelection() {
		if (brickQuantity < 300) {
			return "Truck";
		} else if (brickQuantity >= 300 && brickQuantity < 500) {
			return "Lorry";
		} 
		return "MonsterLorry";
	}
	
	// Determines vehicle cost based on selected vehicle type
	// This keeps pricing logic separate from selection logic
	public double vehiclePrice() {
		String vehiceType = vehicleSelection();
		if (vehiceType.equals("Truck")) {
			return 1000;
		} else if (vehiceType.equals("Lorry")) {
			return 1700;
		}
		return 3000;
	}
	
	// Calculates discount percentage based on transport rating
	// Higher rating gives higher discount to encourage quality service
	public double discountPercentage() {
	    if (transportRating == 5) {
	        return 20;
	    } else if (transportRating == 3 || transportRating == 4) {
	        return 10;
	    }
	    return 0;
	}

	// Implements total charge calculation as defined by abstract method
	// Combines brick cost, vehicle charge, tax, and discount
	@Override
	public float calculateTotalCharge() {
		double price = brickPrice * brickQuantity;
		double tax = price * 0.3;
		double discount = price * discountPercentage() / 100;
		return (float) ((price + vehiclePrice() + tax) - discount);
	}
	
	// Overridden to display both common transport details and brick-specific information
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Quantity of bricks : " + brickQuantity);
		System.out.println("Brick price : " + brickPrice);
		System.out.println("Vehicle for transport: " + vehicleSelection());
		System.out.println("Total charge: " + calculateTotalCharge());
	}
}