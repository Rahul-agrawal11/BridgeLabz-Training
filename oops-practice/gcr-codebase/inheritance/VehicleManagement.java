// Superclass
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

// Electric vehicle subclass
class ElectricVehicle extends Vehicle {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Vehicle charged successfully.");
    }
}

// Petrol vehicle subclass
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Vehicle filled successfully.");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// Main class
class VehicleManagement {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle(50, "Tesla Model Y");
        ev.charge();

        PetrolVehicle pv = new PetrolVehicle(100, "Hyundai Creta");
        pv.refuel();
    }
}
