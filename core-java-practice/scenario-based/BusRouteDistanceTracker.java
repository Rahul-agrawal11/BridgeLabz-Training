import java.util.Scanner;

public class BusRouteDistanceTracker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double totalDistance = 0;
        char choice = 'N';

        while (choice != 'Y' && choice != 'y') {

            System.out.print("Enter distance traveled from last stop (in km): ");
            double distance = input.nextDouble();

            totalDistance += distance;

            System.out.println("Total distance traveled: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (Y/N): ");
            choice = input.next().charAt(0);
        }

        System.out.println("\nPassenger got off the bus.");
        System.out.println("Final distance traveled: " + totalDistance + " km");

        input.close();
    }
}
