// Create a program to convert the distance of 10.8 kilometers to miles. Hint: 1 km = 1.6 miles

class DistanceConversion {
    public static void main(String[] args) {
	    double kilometers = 10.8;
		double mile = 1.6;
		
		double kmToMiles = kilometers * mile;
		
		System.out.println("The distance " + kilometers + " km in miles is " + kmToMiles);
	}
}