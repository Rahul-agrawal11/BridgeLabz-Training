package FunctionalInterface;

import java.util.Scanner;

interface ConversionUtils {
	static double KmToMiles(double km) {
		return km * 0.621371;
	}
	
	static double KgToLbs(double kg) {
		return kg * 2.20462;
	}
}

public class UnitConversionTool {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("======= Unit Conversion Tool =======");
		System.out.println("1. Convert KM to Miles: ");
		System.out.println("2. Convert KG to Lbs: ");
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("Enter KM: ");
			double km = sc.nextDouble();
			System.out.println("Miles: " + ConversionUtils.KmToMiles(km));
			break;
		case 2:
			System.out.println("Enter KG: ");
			double kg = sc.nextDouble();
			System.out.println("Lbs: " + ConversionUtils.KgToLbs(kg));
			break;
		default:
			System.out.println("Invalid choice!");
		}
		sc.close();
	}
}
