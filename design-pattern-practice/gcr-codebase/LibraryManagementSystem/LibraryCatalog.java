package LibraryManagementSystem;

import java.util.*;

class LibraryCatalog {
	private static LibraryCatalog instance;
	private List<Book> books = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();

	private Map<String, List<Book>> reservations = new HashMap<>();

	private Logger logger = Logger.getInstance();

	private LibraryCatalog() {}

	public static synchronized LibraryCatalog getInstance() {
		if (instance == null)
			instance = new LibraryCatalog();
		return instance;
	}

	public void addBook(Book book) {
		books.add(book);
		logger.log("Book added: " + book.getTitle());
		newBookArrived(book.getTitle());
	}

	public void reserveBook(User user, Book book) {

		reservations.putIfAbsent(user.getName(), new ArrayList<>());
		List<Book> userReservedBooks = reservations.get(user.getName());

		ReservationStrategy strategy = user.getReservationStrategy();

		if (!strategy.canReserve(userReservedBooks.size())) {
			logger.log(user.getName() + " failed to reserve. Limit: " + strategy.getMaxLimit());
			System.out.println(user.getName() + " cannot reserve more books! Limit = " + strategy.getMaxLimit());
			return;
		}

		userReservedBooks.add(book);
		logger.log(user.getName() + " reserved book: " + book.getTitle());
		System.out.println(user.getName() + " reserved: " + book.getTitle());
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	private void newBookArrived(String bookName) {
		for (Observer o : observers) {
			o.update("New book available: " + bookName);
		}
	}
}
