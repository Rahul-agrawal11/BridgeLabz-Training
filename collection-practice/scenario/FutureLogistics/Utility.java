package scenario.FutureLogistics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Utility class to hold common helper methods used across the application
// No object state is maintained here
class Utility {

    // Factory-style method that parses input data and returns
    // the appropriate GoodsTransport subclass object
    public GoodsTransport parseDetails(String input) {
        
        // Splitting input string to extract transport details
        String[] data = input.split(":");

        String transportId = data[0];
        String transportDate = data[1];
        int transportRating = Integer.parseInt(data[2]);
        String transportType = data[3];

        // Creates BrickTransport object when input specifies BrickTransport
        if (transportType.equals("BrickTransport")) {
            return new BrickTransport(
                transportId,
                transportDate,
                transportRating,
                Float.parseFloat(data[4]),
                Integer.parseInt(data[5]),
                Float.parseFloat(data[6])
            );
        }

        // Creates TimberTransport object when input specifies TimberTransport
        // Timber type is mapped to a factor value based on quality
        if (transportType.equals("TimberTransport")) {
            float timberType = data[6].equalsIgnoreCase("Premium") ? 0.25f : 0.15f;

            return new TimberTransport(
                transportId,
                transportDate,
                transportRating,
                Float.parseFloat(data[4]),
                Float.parseFloat(data[5]),
                timberType,
                Float.parseFloat(data[7])
            );
        }
        
        // Returns null if transport type is invalid
        return null;
    }

    // Validates transport ID format using regular expression
    // Ensures ID follows a predefined business rule
    public boolean validateTransportId(String transportId) { 
    	String regex = "^RTS[0-9]{3}[A-Z]$"; 
    	Pattern pattern = Pattern.compile(regex); 
    	Matcher matcher = pattern.matcher(transportId); 
    	while (matcher.find()) { 
    		return true; 
    	} 
    	return false; 
    }

    // Determines the actual transport type at runtime
    // Uses instanceof to identify the subclass object
    public String findObjectType(GoodsTransport obj) {
        if (obj instanceof TimberTransport) return "TimberTransport";
        if (obj instanceof BrickTransport) return "BrickTransport";
        return "UnknownTransport";
    }
}
