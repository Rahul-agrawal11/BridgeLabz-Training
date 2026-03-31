package SmartUniversityLibraryManagementSystem;

public class Librarian implements User {
	private String name;

	public Librarian(String name) {
		this.name = name;
	}
	
	@Override
	public void showRole() {
		System.out.println(name + " is a Librarian.");
	}
	
	@Override 
	public int getBorrowLimit() {
		return 0;
	}
	
	public void addBookToCatalog(Book book) {
		LibraryCatalog.getInstance().addBook(book);
	}
	
	@Override
	public void update(String msg) {
		System.out.println(name + " notified: " + msg);
	}
}
