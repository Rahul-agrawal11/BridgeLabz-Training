import java.util.ArrayList;
import java.util.List;

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem implements Reservable {
    private int itemId;
    private String title;
    private String author;

    // Encapsulated borrower data
    private String borrowerName;
    private boolean isAvailable = true;

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Concrete method
    public String getItemDetails() {
        return "ID: " + itemId +
               ", Title: " + title +
               ", Author: " + author;
    }

    // Encapsulation: no direct access to borrower name
    protected void setBorrower(String name) {
        this.borrowerName = name;
        this.isAvailable = false;
    }

    protected void clearBorrower() {
        this.borrowerName = null;
        this.isAvailable = true;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    // Abstract method
    public abstract int getLoanDuration();
}

// Book class
class Book extends LibraryItem {

    Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14; // days
    }

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is not available");
        }
    }
}

// Magazine class
class Magazine extends LibraryItem {

    Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7; // days
    }

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is not available");
        }
    }
}

// DVD class
class DVD extends LibraryItem {

    DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3; // days
    }

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is not available");
        }
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Java Programming", "James Gosling"));
        items.add(new Magazine(2, "Tech Monthly", "Editorial Board"));
        items.add(new DVD(3, "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {

            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println("Available: " + item.checkAvailability());

            item.reserveItem("Rahul");

            System.out.println("----------------------------------");
        }
    }
}
