package LibraryManagementSystem;

public class LibrarianReservationStrategy implements ReservationStrategy {

	@Override
	public boolean canReserve(int currentReservations) {
		return currentReservations < 10;
	}

	@Override
	public int getMaxLimit() {
		return 10;
	}
}
