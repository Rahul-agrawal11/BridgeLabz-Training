
import java.util.Scanner;

public class UnitConverter3 {

    // Convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

    // Convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

    // Convert Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Convert Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Convert Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Convert Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    // Main method at the end with menu loop
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        double value;

        do {
            // Display Menu
            System.out.println("\n===== Unit Converter Menu =====");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Pounds to Kilograms");
            System.out.println("4. Kilograms to Pounds");
            System.out.println("5. Gallons to Liters");
            System.out.println("6. Liters to Gallons");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter the value to convert: ");
            value = input.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println(value + " Fahrenheit = "
                            + String.format("%.2f", convertFahrenheitToCelsius(value)) + " Celsius");
                    break;
                case 2:
                    System.out.println(value + " Celsius = "
                            + String.format("%.2f", convertCelsiusToFahrenheit(value)) + " Fahrenheit");
                    break;
                case 3:
                    System.out.println(value + " Pounds = "
                            + String.format("%.2f", convertPoundsToKilograms(value)) + " Kilograms");
                    break;
                case 4:
                    System.out.println(value + " Kilograms = "
                            + String.format("%.2f", convertKilogramsToPounds(value)) + " Pounds");
                    break;
                case 5:
                    System.out.println(value + " Gallons = "
                            + String.format("%.2f", convertGallonsToLiters(value)) + " Liters");
                    break;
                case 6:
                    System.out.println(value + " Liters = "
                            + String.format("%.2f", convertLitersToGallons(value)) + " Gallons");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        input.close();
    }
}
