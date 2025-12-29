import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class RohanLibraryReminderApp {
	
	// Method to get days between return date and due date
	public static long dateDifference(String returnDate, String dueDate) {
		LocalDate return_date = LocalDate.parse(returnDate);
		LocalDate due_date = LocalDate.parse(dueDate);
		
		return ChronoUnit.DAYS.between(return_date, due_date);
	}
	
	// Method to calculate fine as per days
	public static long toCalculateFine (long days) {
		return days * 5;
	}
	
	public static void main(String[] args) {
		
		// Taking user input
		Scanner input = new Scanner(System.in);

		System.out.print("Input Return date(yyyy-MM-dd): ");
		String returnDate = input.nextLine();
		
		System.out.print("Input Due date(yyyy-MM-dd): ");
		String dueDate = input.nextLine();
		
		// Method call
		long days = dateDifference(returnDate, dueDate);
		long totalFine = toCalculateFine(days);
		
		// Display Results
		System.out.println("Date difference: " + days + " days");
		System.out.println("Total Fine: " + totalFine);
		
	}
}