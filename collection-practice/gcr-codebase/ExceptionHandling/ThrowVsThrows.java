package ExceptionHandling;

public class ThrowVsThrows {
	
	// Method that calculates interest and declares that it may throw IllegalArgumentException
	static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
	    
	    // Validate input: amount and rate must not be negative
	    if (amount < 0 || rate < 0) {
	        // throw: manually create and throw an exception
	        throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
	    }
	    
	    // Calculate simple interest and return it
	    return (amount * rate * years) / 100;
	}

	public static void main(String[] args)  {
		
		// Input values
		double amount = 1000;
		double rate = 5;
		int years = 2;
		
		try {
		    // Call method that may throw an exception
		    double interest = calculateInterest(amount, rate, years);
		    
		    // Print calculated interest if no exception occurs
		    System.out.println("Interest: " + interest);
		} 
		// Catch and handle the propagated exception
		catch (IllegalArgumentException e) {
		    System.out.println("Error: " + e.getMessage());
		}
	}
}
