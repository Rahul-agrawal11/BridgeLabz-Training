import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalWatchSimulation {

	// Method to get current time in 24-format
	public static String getCurrentTime() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return time.format(formatter);
	}

	public static void main(String[] args) {
		
		// Display the time continuously
		while(true) {
			String currentTime = getCurrentTime();
			
			// condition for break
			if (currentTime.equals("13:00:00")) {
				break;
			}
			System.out.println("Current Time: " + currentTime);
		}
	}
}