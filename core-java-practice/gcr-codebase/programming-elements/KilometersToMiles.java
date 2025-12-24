// Create a program to convert distance in kilometers to miles.

import java.util.Scanner;

class KilometersToMiles {
    public static void main(String[] args) {
	    double km;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Kilometers to convert in Miles: ");
		km = input.nextDouble();
		double kmInOneMile = 1.6;
		
		double totalMiles = km * kmInOneMile;
		
		System.out.println("The total miles is " + totalMiles + " mile for the given " + km + " km");
		input.close();
	}
}