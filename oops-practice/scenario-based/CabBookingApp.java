import java.util.List;
import java.util.ArrayList;

/*
 * USER CLASS
 * Represents a customer who books a cab
 */
class User {
	private int userId;
	private String name;
	
	User(int userId, String name) {
		this.userId = userId;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

/*
 * DRIVER CLASS
 * Represents a cab driver and availability status
 */
class Driver {
	private int driverId;
	private String name;
	private boolean available;
	
	Driver(int driverId, String name) {
		this.driverId = driverId;
		this.name = name;
		this.available = true;
	}
	
	public boolean isAvailable() {
		return available;
	} 
	
	public void setAvailable(boolean status) {
		this.available = status;
	}
	
	public String getName() {
		return name;
	}
}

/*
 * RIDE CLASS
 * Stores details of a completed ride
 */
class Ride {
	private User user;
	private Driver driver;
	private double distance;
	private double fare;
	
	public Ride(User user, Driver driver, double distance, double fare) {
		this.user = user;
		this.driver = driver;
		this.distance = distance;
		this.fare = fare;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public String getRideDetails() {
		return "User: " + user.getName() +
		       "\nDriver: " + driver.getName() +
		       "\nDistance: " + distance + " km" +
		       "\nFare: ₹" + fare;
	}
}

/*
 * INTERFACE FOR FARE CALCULATION
 */
interface FareCalculator {
	double calculateFare(double distance);
}

/*
 * NORMAL PRICING
 */
class NormalFareCalculator implements FareCalculator {
	public double calculateFare(double distance) {
		return distance * 12;
	}
}

/*
 * PEAK HOUR PRICING
 */
class PeakFareCalculator implements FareCalculator {
	public double calculateFare(double distance) {
		return distance * 17;
	}
}

/*
 * CUSTOM EXCEPTION
 */
class NoDriverAvailableException extends Exception {
	public NoDriverAvailableException(String message) {
		super(message);
	}
}

/*
 * RIDE SERVICE CLASS
 * Handles CRUD operations
 */
class RideService {

	private static List<Ride> rideHistory = new ArrayList<>();

	// CREATE - Assign driver
	public static Driver assignDriver(List<Driver> drivers)
	        throws NoDriverAvailableException {

		for (Driver d : drivers) {
			if (d.isAvailable()) {
				d.setAvailable(false);
				return d;
			}
		}
		throw new NoDriverAvailableException("No drivers available right now!");
	}

	// CREATE - Book ride
	public static Ride bookRide(
	        User user,
	        List<Driver> drivers,
	        double distance,
	        FareCalculator calculator
	) throws NoDriverAvailableException {

		Driver driver = assignDriver(drivers);
		double fare = calculator.calculateFare(distance);

		Ride ride = new Ride(user, driver, distance, fare);
		rideHistory.add(ride);

		return ride;
	}

	// READ - Ride history
	public static List<Ride> getRideHistory() {
		return rideHistory;
	}

	// DELETE - Remove ride and free driver
	public static boolean deleteRide(int index) {

		if (index < 0 || index >= rideHistory.size()) {
			return false;
		}

		Ride ride = rideHistory.remove(index);
		ride.getDriver().setAvailable(true); // driver becomes available again

		return true;
	}
}

/*
 * MAIN CLASS
 */
class CabBookingApp {
	public static void main(String[] args) {

		User user = new User(1, "Rahul");

		List<Driver> drivers = new ArrayList<>();
		drivers.add(new Driver(101, "Amit"));
		drivers.add(new Driver(102, "Sagar"));

		try {
			RideService.bookRide(user, drivers, 8.5, new PeakFareCalculator());
			RideService.bookRide(user, drivers, 5.0, new NormalFareCalculator());

			System.out.println("---- Ride History BEFORE DELETE ----");
			for (Ride r : RideService.getRideHistory()) {
				System.out.println(r.getRideDetails());
				System.out.println("---------------------");
			}

			// DELETE first ride
			RideService.deleteRide(0);

			System.out.println("---- Ride History AFTER DELETE ----");
			for (Ride r : RideService.getRideHistory()) {
				System.out.println(r.getRideDetails());
				System.out.println("---------------------");
			}

		} catch (NoDriverAvailableException e) {
			System.out.println(e.getMessage());
		}
	}
}
