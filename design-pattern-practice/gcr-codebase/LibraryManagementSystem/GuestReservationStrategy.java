package LibraryManagementSystem;

public class GuestReservationStrategy implements ReservationStrategy {

	@Override
	public boolean canReserve(int currentReservations) {
		return false;
	}

	@Override
	public int getMaxLimit() {
		return 0;
	}
}
