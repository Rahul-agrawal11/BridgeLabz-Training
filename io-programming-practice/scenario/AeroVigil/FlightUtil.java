package scenario.AeroVigil;

public class FlightUtil {
	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {

	    String regex = "^FL-[1-9][0-9]{3}$";

	    if (flightNumber == null || !flightNumber.matches(regex)) {
	        throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
	    }

	    return true;
	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {
		if(!flightName.equals("SpiceJet") && !flightName.equals("Vistara") && !flightName.equals("IndiGo") && !flightName.equals("Air Arabia")) {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		return true;
	}
	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
		if (passengerCount <= 0) {
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		int capacity = takeCapacity(flightName);
		if(passengerCount > capacity) {
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		return true;
	}
	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
		double fuelCapacity = takeFuelCapacity(flightName);
		if(currentFuelLevel <= 0 || currentFuelLevel > fuelCapacity) {
			throw new InvalidFlightException("Invalid fuel level for " + flightName);
		}
		return fuelCapacity - currentFuelLevel;
	}
	
	public static int takeCapacity(String flightName) {
		if(flightName.equals("SpiceJet")) {
			return 396;
		} else if (flightName.equals("Vistara")) {
			return 615;
		} else if (flightName.equals("IndiGo")) {
			return 230;
		} else if (flightName.equals("Air Arabia")) {
			return 130;
		}
		return 0;
	}
	
	public static double takeFuelCapacity(String flightName) {
		if(flightName.equals("SpiceJet")) {
			return 200000;
		} else if (flightName.equals("Vistara")) {
			return 300000;
		} else if (flightName.equals("IndiGo")) {
			return 250000;
		} else if (flightName.equals("Air Arabia")) {
			return 150000;
		}
		return 0;
	}
}
