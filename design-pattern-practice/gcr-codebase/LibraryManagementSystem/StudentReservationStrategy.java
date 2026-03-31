package LibraryManagementSystem;

public class StudentReservationStrategy implements ReservationStrategy {

	@Override
	public boolean canReserve(int currentReservations) {
		return currentReservations < 2;
	}

	@Override
	public int getMaxLimit() {
		return 2;
	}
}
