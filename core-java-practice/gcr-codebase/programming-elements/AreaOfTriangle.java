// Write a program that takes the base and height in cm to find the area of a triangle in square inches and square centimeters 

import java.util.Scanner;

class AreaOfTriangle {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter height of triangle: ");
		float height = input.nextFloat();
		
		System.out.print("Enter base of triangle: ");
		float base = input.nextFloat();
		
		float ONE_INCH = 2.54f;
		
		float arearOfTriangle = (1.0f/2.0f) * base * height;
		float areaInInches = arearOfTriangle / ONE_INCH;
		
		System.out.println("The Area of the triangle in sq in is " + areaInInches + " and sq cm is " + arearOfTriangle);
		input.close();
	}
}