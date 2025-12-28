import java.util.Scanner;

public class UnitConverter2 {

    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Display Menu
        System.out.println("1. Convert Yards to Feet");
        System.out.println("2. Convert Feet to Yards");
        System.out.println("3. Convert Meters to Inches");
        System.out.println("4. Convert Inches to Meters");
        System.out.println("5. Convert Inches to Centimeters");

        System.out.print("Enter value: ");
        double value = input.nextDouble();

        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(value + " yards are equal to " +
                        convertYardsToFeet(value) + " feet.");
                break;

            case 2:
                System.out.println(value + " feet are equal to " +
                        convertFeetToYards(value) + " yards.");
                break;

            case 3:
                System.out.println(value + " meters are equal to " +
                        convertMetersToInches(value) + " inches.");
                break;

            case 4:
                System.out.println(value + " inches are equal to " +
                        convertInchesToMeters(value) + " meters.");
                break;

            case 5:
                System.out.println(value + " inches are equal to " +
                        convertInchesToCentimeters(value) + " centimeters.");
                break;

            default:
                System.out.println("Invalid choice.");
        }

        input.close();
    }
}
