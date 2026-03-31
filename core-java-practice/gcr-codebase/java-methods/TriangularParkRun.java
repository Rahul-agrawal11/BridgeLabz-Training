import java.util.Scanner;

public class TriangularParkRun {

    // Method to calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;   // 5 km = 5000 meters
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = input.nextDouble();

        // Method call
        double rounds = calculateRounds(side1, side2, side3);

        // Output
        System.out.println("The athlete must complete " + rounds + " rounds to run 5 km.");

        input.close();
    }
}
