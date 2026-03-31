package FunctionalInterface;

import java.util.function.Predicate;
import java.util.Scanner;

public class TemperatureAlertSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double threshold = 40.0;
		Predicate<Double> checkTemp = n -> n > threshold;
		
		System.out.println("Enter Temperature: ");
		double temp = sc.nextDouble();
		
		if(checkTemp.test(temp)) {
			System.out.println("Warning: Temperature crossed threshold.");
		} else {
			System.out.println("Temperature is normal.");
		}
		sc.close();
	}
}
