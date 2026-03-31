package SmartUniversityLibraryManagementSystem;

public class LibraryApp {
	public static void main(String[] args) {
		// Singleton
		LibraryCatalog catalog = LibraryCatalog.getInstance();
		
		// Factory
		User student = UserFactory.createUser("student", "Rohan Singhal");
		User faculty = UserFactory.createUser("faculty", "Rahul Agrawal");
		User librarian = UserFactory.createUser("librarian", "Sagar Pandey");
		
		Librarian lib = (Librarian) librarian;
		// Observer registration
		catalog.addObserver(student);
		catalog.addObserver(faculty);
		catalog.addObserver(librarian);
		
		student.showRole();
		System.out.println("Borrow Limit: " + student.getBorrowLimit());

		faculty.showRole();
		System.out.println("Borrow Limit: " + faculty.getBorrowLimit());
		
		librarian.showRole();
		
		// Builder
		Book book1 = new Book.BookBuilder("Design Patterns").author("GoF")
				.edition("2nd").genre("Software Engineering").subgenre("Best Practice for Programming")
				.publisherInfo("Rahul Agrawal").build();
		lib.addBookToCatalog(book1);
	}
}
