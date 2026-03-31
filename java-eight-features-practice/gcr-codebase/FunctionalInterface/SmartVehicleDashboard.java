package FunctionalInterface;

interface VehicleDashboard {

    void displaySpeed(int speed);

    default void displayBattery(int batteryPercent) {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class PetrolCar implements VehicleDashboard {

    @Override
    public void displaySpeed(int speed) {
        System.out.println("Petrol Car Speed: " + speed + " km/h");
    }
}

class ElectricCar implements VehicleDashboard {

    @Override
    public void displaySpeed(int speed) {
        System.out.println("Electric Car Speed: " + speed + " km/h");
    }

    @Override
    public void displayBattery(int batteryPercent) {
        System.out.println("Battery: " + batteryPercent + "%");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {

        VehicleDashboard petrol = new PetrolCar();
        petrol.displaySpeed(80);
        petrol.displayBattery(0); // default method

        VehicleDashboard ev = new ElectricCar();
        ev.displaySpeed(100);
        ev.displayBattery(75); // overridden
    }
}
