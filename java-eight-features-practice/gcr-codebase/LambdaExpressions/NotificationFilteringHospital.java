package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Alert {
	String type;
	String message;
	public Alert(String type, String message) {
		this.type = type;
		this.message = message;
	}
}

public class NotificationFilteringHospital {

	public static void main(String[] args) {
		List<Alert> alerts = new ArrayList<>();
		alerts.add(new Alert("EMERGENCY", "Heart rate critical!"));
		alerts.add(new Alert("MEDICINE", "Take insulin at 9 PM"));
		alerts.add(new Alert("APPOINTMENT", "Doctor visit tomorrow 10 AM"));
		alerts.add(new Alert("REPORT", "Blood test report available"));
		alerts.add(new Alert("EMERGENCY", "Oxygen level low!"));
		
		String userPreference = "EMERGENCY";
		
		Predicate<Alert> filter = alert -> alert.type.equals(userPreference);
		
		System.out.println("Showing only: " + userPreference + " alerts\n");
		
		alerts.stream().filter(filter).forEach(a -> System.out.println(a.type + " -> " + a.message));
	}

}
