class Book {
	
	// Attributes
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "2States";
        author = "Chetan Bhagat";
        price = 500.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
	
	// Display Details
    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

		// Default Constructor
        Book book1 = new Book();
        System.out.println("Book 1:");
        book1.displayBook();

		// Parameterized Constructor
        Book book2 = new Book("Atomic Habits", "James Clear", 499);
        System.out.println("\nBook 2:");
        book2.displayBook();
	}
}
