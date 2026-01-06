import java.util.ArrayList;
import java.util.List;

// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    // Encapsulated GPS data
    private String currentLocation = "Unknown";

    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId +
               ", Driver: " + driverName;
    }

    // GPS methods
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

// Car
class Car extends Vehicle {

    Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm + 50; // base fare
    }
}

// Bike
class Bike extends Vehicle {

    Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}

// Auto
class Auto extends Vehicle {

    Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm + 20; // service charge
    }
}

// Fare Calculator (Polymorphism)
class FareCalculator {

    public static double calculateRideFare(Vehicle vehicle, double distance) {
        return vehicle.calculateFare(distance); // dynamic binding
    }
}

// Main class
public class RideHailingApp {

    public static void main(String[] args) {

        List<Vehicle> rides = new ArrayList<>();

        rides.add(new Car("CAR101", "Rahul", 15));
        rides.add(new Bike("BIKE202", "Amit", 8));
        rides.add(new Auto("AUTO303", "Suresh", 10));

        double distance = 12.5;

        for (Vehicle v : rides) {

            v.updateLocation("City Center");

            System.out.println(v.getVehicleDetails());
            System.out.println("Current Location: " + v.getCurrentLocation());

            // Polymorphic call
            double fare = FareCalculator.calculateRideFare(v, distance);
            System.out.println("Fare for " + distance + " km: ₹" + fare);

            System.out.println("--------------------------------");
        }
    }
}
