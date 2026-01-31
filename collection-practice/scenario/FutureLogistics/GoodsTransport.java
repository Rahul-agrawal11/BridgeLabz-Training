package scenario.FutureLogistics;

// Base abstract class for all transport types
public abstract class GoodsTransport {
	
	// Common properties shared by all transport types
	protected String transportId;
	protected String transportDate;
	protected int transportRating;
	
	// Common constructor to initialize shared transport data
	public GoodsTransport(String transportId, String transportDate, int transportRating) {
		this.transportId = transportId;
		this.transportDate = transportDate;
		this.transportRating = transportRating;
	}

	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public int getTransportRating() {
		return transportRating;
	}

	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}
	
	// Enforces vehicle selection logic in each specific transport type
	abstract public String vehicleSelection();
	
	// Forces each subclass to implement its own charge calculation logic
	abstract public float calculateTotalCharge();
	
	// Common display logic reused by all subclasses
	public void displayDetails() {
		System.out.println("Transporter id : " + transportId);
		System.out.println("Date of transport: " + transportDate);
		System.out.println("Rating of the transport: " + transportRating);
	}
}
