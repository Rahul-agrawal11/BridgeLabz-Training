package scenario.MovieScheduleManager;

// Custom checked exception
public class InvalidTimeFormatException extends Exception {

    public InvalidTimeFormatException(String message) {
        super(message);
    }
}