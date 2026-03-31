package LibraryManagementSystem;

public interface User extends Observer {
	void showRole();
	String getName();
	ReservationStrategy getReservationStrategy();
}
