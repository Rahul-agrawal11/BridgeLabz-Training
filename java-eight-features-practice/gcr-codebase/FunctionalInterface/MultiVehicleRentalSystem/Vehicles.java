package FunctionalInterface.MultiVehicleRentalSystem;

class Car implements VehicleRent {
	@Override
	public void rent() {
		System.out.println("Rent: $1200");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle Type: Car");
	}
}

class Bike implements VehicleRent {
	@Override
	public void rent() {
		System.out.println("Rent: $500");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle Type: Bike");
	}
}

class Bus implements VehicleRent {
	@Override
	public void rent() {
		System.out.println("Rent: $10000");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle Type: Bus");
	}
}

public class Vehicles {

	public static void main(String[] args) {
		
		Car car = new Car();
		car.rent();
		car.returnVehicle();
		System.out.println();
		
		Bike bike = new Bike();
		bike.rent();
		bike.returnVehicle();
		System.out.println();
		
		Bus bus = new Bus();
		bus.rent();
		bus.returnVehicle();
		System.out.println();
	}

}
