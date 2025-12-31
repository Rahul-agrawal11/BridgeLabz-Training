class LibraryBook {
	
	// Attributes
    String title;
    String author;
    double price;
    boolean availability;

	// Parameterized Constructor
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }
	
	// Check for availability of book
    boolean borrowBook() {
        if (availability) {
            availability = false;
            return true;
        }
        return false;
    }
	
	// Display Book Details
    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Available: " + availability);
    }

    public static void main(String[] args) {
		
		// Parameterized Constructor
        LibraryBook book = new LibraryBook("Wings of Fire", "A.P.J Abdul Kalam", 299);

        book.displayBook();
        System.out.println("Borrowing book: " + book.borrowBook());
		System.out.println();
        book.displayBook();
    }
}
