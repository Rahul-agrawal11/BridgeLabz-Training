package scenario.FutureLogistics;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	// Step 1: extract transportId
    	System.out.println("Enter details: ");
        String input = sc.next();
        sc.close();
        String transportId = input.split(":")[0];

        // Step 2: Parse details and get GoodsTransport reference
        Utility utility = new Utility();
        GoodsTransport transport = utility.parseDetails(input);
        if(!utility.validateTransportId(transportId)) {
        	System.out.println("Transport id " + transportId + " is invalid\nPlease provide a valid record");
        	return;
        }
        
        // Step 3: Find object type
        String transportType = utility.findObjectType(transport);

        // Step 4 & 5: Check instance, calculate charge & display details
        if (transportType.equals("BrickTransport") ||
            transportType.equals("TimberTransport")) {

            // calculateTotalCharge() invoked internally in displayDetails
            transport.displayDetails();
        }
    }
}
