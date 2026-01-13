import java.util.ArrayList;
import java.util.Iterator;

interface IRentable {
    double calculateRent(int days);
}

abstract class Vehicle implements IRentable {

    protected String type;
    protected String vehicleNum;
    protected double rentalRate;

    Vehicle(String type, String vehicleNum, double rentalRate) {
        this.type = type;
        this.vehicleNum = vehicleNum;
        this.rentalRate = rentalRate;
    }

    public String displayInfo() {
        return "Vehicle Number: " + vehicleNum +
               ", Type: " + type +
               ", Rental Rate: " + rentalRate;
    }
}

class Car extends Vehicle {

    Car(String number, double rentalRate) {
        super("Car", number, rentalRate);
    }

    public double calculateRent(int days) {
        return days * rentalRate;
    }
}

class Bike extends Vehicle {

    Bike(String number, double rentalRate) {
        super("Bike", number, rentalRate);
    }

    public double calculateRent(int days) {
        return days * rentalRate;
    }
}

class Truck extends Vehicle {

    Truck(String number, double rentalRate) {
        super("Truck", number, rentalRate);
    }

    public double calculateRent(int days) {
        return days * rentalRate;
    }
}

public class VehicleRentalSystem {

    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    // CREATE
    public static void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    // READ
    public static void displayVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println(v.displayInfo());
        }
    }

    // UPDATE
    public static void updateRentalRate(String vehicleNum, double newRate) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNum.equals(vehicleNum)) {
                v.rentalRate = newRate;
            }
        }
    }

    // DELETE
    public static void deleteVehicle(String vehicleNum) {
        Iterator<Vehicle> itr = vehicles.iterator();
        while (itr.hasNext()) {
            if (itr.next().vehicleNum.equals(vehicleNum)) {
                itr.remove();
            }
        }
    }

    public static void main(String[] args) {

        // ================= CREATE =================
        Vehicle v1 = new Car("Car101", 500);
        Vehicle v2 = new Bike("Bike101", 200);
        Vehicle v3 = new Truck("Truck101", 800);

        addVehicle(v1);
        addVehicle(v2);
        addVehicle(v3);

        // ================= READ =================
        System.out.println("---- Vehicle List ----");
        displayVehicles();

        // ================= UPDATE =================
        System.out.println("\n---- Updating Rental Rate of Bike101 ----");
        updateRentalRate("Bike101", 250);

        // READ after UPDATE
        System.out.println("---- Vehicle List After Update ----");
        displayVehicles();

        // ================= DELETE =================
        System.out.println("\n---- Deleting Truck101 ----");
        deleteVehicle("Truck101");

        // READ after DELETE
        System.out.println("---- Vehicle List After Delete ----");
        displayVehicles();

        // ================= RENT CALCULATION =================
        System.out.println("\n---- Rent Calculation ----");
        System.out.println("Rent for Car101 (3 days): " + v1.calculateRent(3));
    }
}
