import java.util.Scanner;

public class WindChillCalculator {

    // Method to calculate wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74
                + (0.6215 * temperature)
                + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temperature = input.nextDouble();

        System.out.print("Enter the wind speed (in mph): ");
        double windSpeed = input.nextDouble();

        // Method call
        double windChill = calculateWindChill(temperature, windSpeed);

        // Output
        System.out.println("The Wind Chill Temperature is: " + windChill);

        input.close();
    }
}