class Book {
	
	// Attributes
	public long isbn;
	protected String title;
	private String author;
	
	// Constructor
	Book(long isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	// Public getter for Author
	public String getAuthor() {
		return author;
	}
	
	// Public setter for Author
	public void setAuthor(String author) {
		this.author = author;
	}
}

class EBook extends Book {
	
	EBook(long isbn, String title, String author) {
		super(isbn, title, author);
	}
	
	void displayDetails() {
        System.out.println("ISBN Number: " + isbn); // public
        System.out.println("Title: " + title);               // protected
        System.out.println("Author: " + getAuthor());           // private via getter
    }
	
	public static void main(String[] args) {

        EBook ebook = new EBook(123456789321l, "2States", "Chetan Bhagat");

        ebook.displayDetails();
	}
}
