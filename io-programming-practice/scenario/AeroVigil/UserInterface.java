package scenario.AeroVigil;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) throws NumberFormatException, InvalidFlightException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter flight details: ");
		String details = sc.nextLine().trim();
		String[] data = details.split(":");
		
		FlightUtil flightUtil = new FlightUtil();
		
		try {
			if (flightUtil.validateFlightNumber(data[0]) && flightUtil.validateFlightName(data[1]) && flightUtil.validatePassengerCount(Integer.valueOf(data[2]), data[1])) {
				double fuelRequired = flightUtil.calculateFuelToFillTank(data[1], Integer.valueOf(data[3]));
				System.out.println("Fuel required to fill the tank: " + fuelRequired);
			}
		} catch(InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
