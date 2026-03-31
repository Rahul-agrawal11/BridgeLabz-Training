class Vehicle {
	
	// Static variable shared across all products
	private static double registrationFee = 150.0;
	
	// Final variable to ensure registration number cannot be changed once assigned
	private final String registrationNumber;
	private String ownerName;
	private String vehicleType;
	
	// Constructor using 'this' to avoid ambiguity
	Vehicle(String ownerName, String vehicleType, String registrationNumber) {
		this.ownerName = ownerName;             
		this.vehicleType = vehicleType;
		this.registrationNumber = registrationNumber;        // Final variable assigned only once         
	}
	
	// Static method to display registration fee
	public static void displayRegistrationFee() {
		System.out.println("Registration Fee: $" + registrationFee);
	}
	
	// Method to display vehicle details
	public void displayVehicleDetails(Object obj) {
		if(obj instanceof Vehicle) {
			System.out.println("Owner Name: " + ownerName);
			System.out.println("Vehicle Type: " + vehicleType);
			System.out.println("Registration No: " + registrationNumber);
			displayRegistrationFee();
		} else {
			System.out.println("Invalid Vehicle instance");
		}
	}
	
	// Getters and setters
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getVehicleType() {
		return registrationNumber;
	}
	
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public void updateRegFee(Object obj, double newRegistrationFee) {
		if (obj instanceof Vehicle) {
			this.registrationFee += newRegistrationFee;
			System.out.println("Updated Registration Fee: " + registrationFee);			
		}
	}
	
	// Main method for testing
	public static void main(String[] args) {
		// Creating Vehicle details
		Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
		Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");
		
		// Display employee details
		vehicle1.displayVehicleDetails(vehicle1);
		vehicle2.displayVehicleDetails(vehicle2);
		
		vehicle2.updateRegFee(vehicle2, 200.0);
		vehicle2.displayVehicleDetails(vehicle2);
	}	
}