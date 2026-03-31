import java.util.Scanner;

public class UnitConverter {

	// Method to convert km to miles
    public static double convertKmToMiles(double km) {
		double km2miles = 0.621371;
        return km * km2miles;
    }

	// Method to convert miles to km
    public static double convertMilesToKm(double miles) {
		double miles2km = 1.60934;
        return miles * miles2km;
    }

	// Method to convert meters to feet
    public static double convertMetersToFeet(double meters) {
		double meters2feet = 3.28084;
        return meters * meters2feet;
    }

	// Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {
		double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {

		// Display Menu
        System.out.println("1. Convert Km To Miles");
        System.out.println("2. Convert Miles To Km");
        System.out.println("3. Convert Meters To Feet");
        System.out.println("4. Convert Feet To Metes");
		
		// Taking user input
		Scanner input = new Scanner(System.in);

		System.out.print("Enter value: ");
        double value = input.nextDouble();
		
        System.out.println("Enter choice: ");
        int choice = input.nextInt();

        

        switch (choice) {
            case 1:
                double miles = convertKmToMiles(value);
                System.out.println(value + " km are equal to " + miles + " miles.");
                break;

            case 2:
                double km = convertMilesToKm(value);
                System.out.println(value + " miles are equal to " + km + " km.");
                break;

            case 3:
                double feet = convertMetersToFeet(value);
                System.out.println(value + " meters are equal to " + feet + " feet.");
                break;

            case 4:
                double meters = convertFeetToMeters(value);
                System.out.println(value + " feet are equal to " + meters + " meters.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
