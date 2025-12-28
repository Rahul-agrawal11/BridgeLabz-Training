import java.util.Scanner;

public class TrigonometricFunctions {

    // Method to calculate trigonometric functions
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert degrees to radians
        double radians = Math.toRadians(angle);

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();

        // Method call
        double[] result = calculateTrigonometricFunctions(angle);

        // Output
        System.out.println("Sine of " + angle + "° is: " + result[0]);
        System.out.println("Cosine of " + angle + "° is: " + result[1]);
        System.out.println("Tangent of " + angle + "° is: " + result[2]);

        input.close();
    }
}
