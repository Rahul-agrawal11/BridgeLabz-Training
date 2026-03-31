package LibraryManagementSystem;

class Librarian implements User {
	private String name;
	private ReservationStrategy reservationStrategy = new LibrarianReservationStrategy();
	
	public Librarian(String name) {
		this.name = name;
	}

	public void showRole() {
		System.out.println(name + " is a Librarian.");
	}

	public void update(String msg) {
		System.out.println(name + " notified: " + msg);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public ReservationStrategy getReservationStrategy() {
		return reservationStrategy;
	}
}