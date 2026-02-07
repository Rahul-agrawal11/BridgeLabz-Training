package LibraryManagementSystem;

public class FacultyReservationStrategy implements ReservationStrategy {

	@Override
	public boolean canReserve(int currentReservations) {
		return currentReservations < 5;
	}

	@Override
	public int getMaxLimit() {
		return 5;
	}
}
