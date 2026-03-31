class CarRental {

	// Attributes
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

	// Default Constructor
    CarRental() {
        customerName = "Yash";
        carModel = "Hatchback";
        rentalDays = 1;
        costPerDay = 1000;
    }
	
	// Parameterized Constructor
    CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }
	
	// Calculate Total Cost
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

	// Display Rental Details
    void displayRental() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
	
		// Default Constructor
        CarRental r1 = new CarRental();
        System.out.println("Rental 1:");
        r1.displayRental();

		// Parameterized Constructor
        CarRental r2 = new CarRental("Rahul", "SUV", 4, 2500);
        System.out.println("\nRental 2:");
        r2.displayRental();
    }
}
