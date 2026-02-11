package scenario.OnlineClassroomAttendanceTracker;

public class ClassroomMain {
	public static void main(String[] args) {

		AttendanceService service = new AttendanceService();

		// Register Students
		service.registerStudent("S101");
		service.registerStudent("S102");
		service.registerStudent("S103");

		try {
			service.markAttendance("SESSION-1", "S101");
			service.markAttendance("SESSION-1", "S102");
			service.markAttendance("SESSION-2", "S103");

			service.markAttendance("SESSION-1", "S101"); // Duplicate -> Exception

		} catch (DuplicateAttendanceException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		// Remove attendance
		System.out.println("\nRemove S102 from SESSION-1: " + service.removeAttendance("SESSION-1", "S102"));

		// Display
		service.displayAllAttendance();

		System.out.println("\nAttendance of SESSION-1: " + service.getAttendanceBySession("SESSION-1"));
	}
}
