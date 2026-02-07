package LibraryManagementSystem;

public interface ReservationStrategy {
	boolean canReserve(int currentReservations);
	int getMaxLimit();
}
