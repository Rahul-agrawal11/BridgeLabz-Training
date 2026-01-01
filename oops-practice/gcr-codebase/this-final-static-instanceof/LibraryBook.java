class LibraryBook {
	
	// Static variable shared across all accounts
	private static String libraryName = "Baldev Library";
	
	// Final variable to ensure isbn number cannot be changed once assigned
	private final String isbn;
	private String title;
	private String author;
	
	// Constructor using 'this' to avoid ambiguity
	public LibraryBook(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;       // Final variable assigned only once
	}
	
	// Static method to get library name
	public static void displayLibraryName() {
		System.out.println("Library Name: " + libraryName);
	}
	
	// Method to display book details
	public void displayBookDetails() {
		if(this instanceof LibraryBook) {
			System.out.println("Title: " + title);
			System.out.println("Author: " + author);
			System.out.println("ISBN: " + isbn);
		} else {
			System.out.println("Invalid library instance");
		}
	}
	
	// Getters and setters
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// Main method for testing
	public static void main(String[] args) {
		// Create two book accounts
		LibraryBook book1 = new LibraryBook("2States", "Chetan Bhagat", "123-456987456");
		LibraryBook book2 = new LibraryBook("Effective Java", "Joshua Bloch", "978-0134685991");
		
		// Display Library Name
		LibraryBook.displayLibraryName();
		
		// Display book details
		System.out.println("\nBook 1 Details: ");
		book1.displayBookDetails();
		System.out.println("\nBook 2 Details: ");
		book2.displayBookDetails();
		
		
	}
	
	
}