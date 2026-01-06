import java.util.ArrayList;
import java.util.List;

// Interface
interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    // Encapsulated sensitive data
    private String insurancePolicyNumber;

    Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    protected String getInsurancePolicyNumber() {
        return "POLICY-XXXX"; // masked
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle {

    Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance(int days) {
        return 150 * days;
    }

    public String getInsuranceDetails() {
        return "Car Insurance (Standard Coverage)";
    }
}

// Bike class
class Bike extends Vehicle {

    Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance(int days) {
        return 50 * days;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance (Basic Coverage)";
    }
}

// Truck class
class Truck extends Vehicle {

    Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days + 500; // extra handling charge
    }

    public double calculateInsurance(int days) {
        return 300 * days;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance (Heavy Vehicle Coverage)";
    }
}

// Main class
public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 2000, "CAR-POL-1"));
        vehicles.add(new Bike("BIKE202", 800, "BIKE-POL-2"));
        vehicles.add(new Truck("TRUCK303", 5000, "TRUCK-POL-3"));

        int days = 3;

        for (Vehicle v : vehicles) {
            double rent = v.calculateRentalCost(days);
            double insurance = v.calculateInsurance(days);

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost for " + days + " days: ₹" + rent);
            System.out.println("Insurance Cost: ₹" + insurance);
            System.out.println("Insurance Details: " + v.getInsuranceDetails());
            System.out.println("----------------------------------");
        }
    }
}