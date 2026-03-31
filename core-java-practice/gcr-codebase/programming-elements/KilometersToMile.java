import java.util.Scanner;

class KilometersToMile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();

        double miles = kilometers * 0.621371;

        System.out.println("Distance in miles = " + miles);
    }
}
