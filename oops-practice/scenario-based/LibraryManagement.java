import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class BookNotAvailableException extends Exception {
    BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " +
               (isAvailable ? "Available" : "Checked Out");
    }
}

class LibraryUtils {

    // Convert array to list
    public static List<Book> convertArrayToList(Book[] books) {
        List<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            bookList.add(b);
        }
        return bookList;
    }

    // Search books by partial title
    public static List<Book> searchByTitle(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    // Checkout book
    public static boolean checkoutBook(List<Book> books, String title)
            throws BookNotAvailableException {

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isAvailable()) {
                    throw new BookNotAvailableException(
                        "Book '" + title + "' is not available."
                    );
                }
                b.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    // Display books
    public static void displayBooks(List<Book> books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        // Book data stored in Array
        Book[] bookArray = {
            new Book("Java Programming", "James Gosling", true),
            new Book("Effective Java", "Joshua Bloch", true),
            new Book("Python Basics", "Guido van Rossum", false),
            new Book("Data Structures in Java", "Mark Allen", true)
        };

        // Convert Array to List
        List<Book> library = LibraryUtils.convertArrayToList(bookArray);

        System.out.println("All Books:");
        LibraryUtils.displayBooks(library);

        System.out.println("\nSearch Result (keyword: 'Java'):");
        List<Book> foundBooks =
                LibraryUtils.searchByTitle(library, "Java");
        LibraryUtils.displayBooks(foundBooks);

        System.out.println("\nAttempting Checkout:");
        try {
            LibraryUtils.checkoutBook(library, "Python Basics");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCheckout Successful:");
        try {
            LibraryUtils.checkoutBook(library, "Effective Java");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nUpdated Book Status:");
        LibraryUtils.displayBooks(library);
    }
}