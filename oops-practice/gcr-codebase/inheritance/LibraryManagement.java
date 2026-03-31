// Super Class 
class Book {
	String title;
	int publicationYear;
	
	Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}
}

// Subclass of Book
class Author extends Book {
	String name;
	String bio;
	
	Author(String title, int publicationYear, String name, String bio) {
		// will call super class constructor
		super(title, publicationYear);
		this.name = name;
		this.bio = bio;
	}
	
	void displayInfo() {
		System.out.println("Book Title: " + title);
		System.out.println("Book Publication Year: " + publicationYear);
		System.out.println("Author:  " + name);
		System.out.println("Bio: " + bio);
	}
}

// Main class 
public class LibraryManagement {
	public static void main(String[] args) {
		Author author = new Author("Hamari Adhoori Kahani", 2021, "Rahul", "Agrawal");
		author.displayInfo();		
	}
}