import java.util.Scanner;

class LibraryManagementSystem {

    // Arrays to store book data
    static String[] titles = new String[5];
    static String[] authors = new String[5];
    static boolean[] status = new boolean[5]; // true = available, false = checked out

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize books
        initializeBooks();

        // Display all books
        displayBooks();

        // Search book by partial title
        System.out.print("\nEnter partial title to search: ");
        String searchText = sc.nextLine();
        searchBook(searchText);

        // Checkout a book
        System.out.print("\nEnter exact title to checkout: ");
        String checkoutTitle = sc.nextLine();
        checkoutBook(checkoutTitle);

        // Display updated list
        System.out.println("\nUpdated Book List:");
        displayBooks();
    }

    // Step 3: Initialize book data
    static void initializeBooks() {
        titles[0] = "Java Programming";
        authors[0] = "James Gosling";
        status[0] = true;

        titles[1] = "Python Basics";
        authors[1] = "Guido van Rossum";
        status[1] = true;

        titles[2] = "Data Structures";
        authors[2] = "Mark Allen Weiss";
        status[2] = true;
    }

    // Step 4: Display books
    static void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null) {
                System.out.println(
                    "Title: " + titles[i] +
                    ", Author: " + authors[i] +
                    ", Status: " + (status[i] ? "Available" : "Checked Out")
                );
            }
        }
    }

    // Step 5: Search book by partial title
    static void searchBook(String searchText) {
        boolean found = false;
        String search = searchText.toLowerCase();

        System.out.println("\nSearch Results:");
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null) {
                String bookTitle = titles[i].toLowerCase();
                if (bookTitle.contains(search)) {
                    System.out.println(
                        "Title: " + titles[i] +
                        ", Author: " + authors[i] +
                        ", Status: " + (status[i] ? "Available" : "Checked Out")
                    );
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No books found with given title.");
        }
    }

    // Step 6: Checkout book
    static void checkoutBook(String titleToCheckout) {
        boolean found = false;

        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null && titles[i].equalsIgnoreCase(titleToCheckout)) {
                found = true;
                if (status[i]) {
                    status[i] = false;
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Book is already checked out.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }
}