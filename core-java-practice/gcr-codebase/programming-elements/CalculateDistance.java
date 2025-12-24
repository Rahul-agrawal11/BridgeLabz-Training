// Write a program to find the distance in yards and miles for the distance provided by the user in feet

import java.util.Scanner;

class CalculateDistance {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the distance in feet: ");
		float distance = input.nextFloat();
		
		// 1 yard is 3 feet
		final float FEET_PER_YARD = 3.0f;
		
		// 1 mile = 1760 yards
		final float YARDS_PER_MILE = 1760.0f;
		
		float distanceInYard = distance / FEET_PER_YARD;
		float distanceInMile = distanceInYard / YARDS_PER_MILE;
		
		System.out.println("The distance in yards is " + distanceInYard + " while the distance in miles is " + distanceInMile);
		input.close();
	}
}