// Write a program that takes your height in centimeters and converts it into feet and inches

import java.util.Scanner;

class HeightConverter {
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	
	    // One foot = 12 inches
	    int oneFoot = 12;
	
	    // One inch = 2.54 cm
	    double oneInce = 2.54;
	
	    System.out.print("Enter your height in cms: ");
	    double height = input.nextDouble();
	
	    double heightInInches = height / oneInce;
	    double heightInFeet = heightInInches / (double)oneFoot;
	
	    System.out.println("Your Height in cm is " + height + " while in feet is " + heightInFeet + " and inches is " + heightInInches);
		input.close();
	}
    
}