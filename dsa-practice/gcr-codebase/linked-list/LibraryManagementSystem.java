// Book class holds book details
class Book {

    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;

    // Constructor
    Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }
}

// Node class for Doubly Linked List
class Node {

    Book book;     // Data
    Node next;     // Pointer to next node
    Node prev;     // Pointer to previous node

    Node(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
class DoublyLinkedList {

    Node head = null;
    Node tail = null;

    // Add book at beginning
    void insertAtBeginning(int id, String title, String author, String genre, boolean status) {

        Book book = new Book(id, title, author, genre, status);
        Node node = new Node(book);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Add book at end
    void insertAtEnd(int id, String title, String author, String genre, boolean status) {

        Book book = new Book(id, title, author, genre, status);
        Node node = new Node(book);

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // Add book at specific position (1-based index)
    void insertAtPosition(int position, int id, String title, String author, String genre, boolean status) {

        if (position == 1) {
            insertAtBeginning(id, title, author, genre, status);
            return;
        }

        Node current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        Book book = new Book(id, title, author, genre, status);
        Node node = new Node(book);

        node.next = current.next;
        node.prev = current;

        if (current.next != null) {
            current.next.prev = node;
        } else {
            tail = node; // inserted at end
        }

        current.next = node;
    }

    // Remove book by Book ID
    void removeByBookId(int bookId) {

        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        Node current = head;

        while (current != null) {

            if (current.book.bookId == bookId) {

                // If deleting head
                if (current == head) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                    else
                        tail = null;
                }
                // If deleting tail
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // If deleting middle node
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                System.out.println("Book removed successfully");
                return;
            }

            current = current.next;
        }

        System.out.println("Book not found");
    }

    // Search book by title
    void searchByTitle(String title) {

        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.book.title.equalsIgnoreCase(title)) {
                displayBook(current.book);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }

    // Search book by author
    void searchByAuthor(String author) {

        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.book.author.equalsIgnoreCase(author)) {
                displayBook(current.book);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No books found for this author");
        }
    }

    // Update availability status
    void updateAvailability(int bookId, boolean status) {

        Node current = head;

        while (current != null) {
            if (current.book.bookId == bookId) {
                current.book.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found");
    }

    // Display books in forward order
    void displayForward() {

        Node current = head;
        System.out.println("\nBooks (Forward Order):");

        while (current != null) {
            displayBook(current.book);
            current = current.next;
        }
    }

    // Display books in reverse order
    void displayReverse() {

        Node current = tail;
        System.out.println("\nBooks (Reverse Order):");

        while (current != null) {
            displayBook(current.book);
            current = current.prev;
        }
    }

    // Count total books
    void countBooks() {

        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Total number of books: " + count);
    }

    // Helper method to display book details
    void displayBook(Book b) {
        System.out.println(
            "Book ID: " + b.bookId +
            "\nTitle: " + b.title +
            "\nAuthor: " + b.author +
            "\nGenre: " + b.genre +
            "\nAvailable: " + (b.isAvailable ? "Yes" : "No") +
            "\n----------------------"
        );
    }
}

// Main class
class LibraryManagementSystem {

    public static void main(String[] args) {

        DoublyLinkedList library = new DoublyLinkedList();

        // Add books
        library.insertAtBeginning(101, "Java Programming", "James Gosling", "Programming", true);
        library.insertAtEnd(102, "Clean Code", "Robert Martin", "Software", true);
        library.insertAtEnd(103, "The Alchemist", "Paulo Coelho", "Fiction", false);
        library.insertAtPosition(2, 104, "Data Structures", "Mark Allen", "Education", true);

        // Display books
        library.displayForward();
        library.displayReverse();

        // Search operations
        library.searchByTitle("Clean Code");
        library.searchByAuthor("Paulo Coelho");

        // Update availability
        library.updateAvailability(103, true);

        // Remove a book
        library.removeByBookId(101);

        // Count total books
        library.countBooks();

        // Final display
        library.displayForward();
    }
}
