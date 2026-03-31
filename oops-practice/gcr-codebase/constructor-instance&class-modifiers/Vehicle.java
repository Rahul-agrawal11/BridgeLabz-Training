class Vehicle  {

	// Instance Variables
	String ownerName; 
	String vehicleType;
	
	// Class Variable
	static int registrationFee;
	
	// Constructor
	Vehicle(String ownerName, String vehicleType) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
		registrationFee = 1500;
	}
	
	// Instance Method
	void displayVehicleDetails() {
		System.out.println("Owner Name: " + ownerName);
		System.out.println("Vehicle Type: " + vehicleType);
	}
	
	// Class Method
	static void updateRegistrationFee() {
		System.out.println("Registration Fee: " + registrationFee);
		registrationFee = 2000;
		System.out.println("Updated Registration Fee: " + registrationFee);
	}
	
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("Rahul", "Four-wheeler");
		Vehicle vehicle2 = new Vehicle("Rohan", "Two-wheeler");
		
		vehicle1.displayVehicleDetails();
		vehicle2.displayVehicleDetails();
		
		Vehicle.updateRegistrationFee();
		
	}
}