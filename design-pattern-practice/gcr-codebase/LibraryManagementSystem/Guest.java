package LibraryManagementSystem;

class Guest implements User {
	private String name;
	private ReservationStrategy reservationStrategy = new GuestReservationStrategy();

	public Guest(String name) {
		this.name = name;
	}

	public void showRole() {
		System.out.println(name + " is a Guest.");
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
