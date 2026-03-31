// Movie class holds movie details
class Movie {

    String title;
    String director;
    int year;
    double rating;

    // Constructor to initialize movie details
    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

// Node class for Doubly Linked List
class Node {

    Movie movie;   // Data part
    Node next;     // Pointer to next node
    Node prev;     // Pointer to previous node

    // Constructor
    Node(Movie movie) {
        this.movie = movie;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
class DoublyLinkedList {

    Node head = null;  // First node
    Node tail = null;  // Last node

    // Insert movie at the beginning
    void insertAtBeginning(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        Node node = new Node(m);

        // If list is empty
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Insert movie at the end
    void insertAtEnd(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        Node node = new Node(m);

        // If list is empty
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // Insert movie at a specific position (1-based index)
    void insertAtPosition(int position, String title, String director, int year, double rating) {

        if (position == 1) {
            insertAtBeginning(title, director, year, rating);
            return;
        }

        Movie m = new Movie(title, director, year, rating);
        Node node = new Node(m);

        Node current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        node.next = current.next;
        node.prev = current;

        if (current.next != null) {
            current.next.prev = node;
        } else {
            tail = node; // inserting at last position
        }

        current.next = node;
    }

    // Remove movie by title
    void removeByTitle(String title) {

        if (head == null) {
            System.out.println("Movie list is empty");
            return;
        }

        Node current = head;

        while (current != null) {

            if (current.movie.title.equalsIgnoreCase(title)) {

                // If node is head
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                }
                // If node is tail
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // If node is in middle
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                System.out.println("Movie deleted: " + title);
                return;
            }

            current = current.next;
        }

        System.out.println("Movie not found");
    }

    // Search movies by director
    void searchByDirector(String director) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.movie.director.equalsIgnoreCase(director)) {
                displayMovie(current.movie);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search movies by rating
    void searchByRating(double rating) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.movie.rating == rating) {
                displayMovie(current.movie);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Update movie rating using title
    void updateRatingByTitle(String title, double newRating) {
        Node current = head;

        while (current != null) {
            if (current.movie.title.equalsIgnoreCase(title)) {
                current.movie.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found");
    }

    // Display movies in forward order
    void displayForward() {
        Node current = head;

        System.out.println("\nMovies (Forward Order):");
        while (current != null) {
            displayMovie(current.movie);
            current = current.next;
        }
    }

    // Display movies in reverse order
    void displayReverse() {
        Node current = tail;

        System.out.println("\nMovies (Reverse Order):");
        while (current != null) {
            displayMovie(current.movie);
            current = current.prev;
        }
    }

    // Helper method to display movie details
    void displayMovie(Movie m) {
        System.out.println(
            "Title: " + m.title +
            "\nDirector: " + m.director +
            "\nYear: " + m.year +
            "\nRating: " + m.rating +
            "\n----------------------"
        );
    }
}

// Main class
class MovieManagementSystem {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        // Add movies
        list.insertAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        list.insertAtEnd("Interstellar", "Christopher Nolan", 2014, 8.8);
        list.insertAtEnd("Titanic", "James Cameron", 1997, 8.5);
        list.insertAtPosition(2, "Avatar", "James Cameron", 2009, 7.9);

        // Display movies
        list.displayForward();
        list.displayReverse();

        // Search operations
        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.5);

        // Update rating
        list.updateRatingByTitle("Avatar", 8.2);

        // Remove movie
        list.removeByTitle("Titanic");

        // Final display
        list.displayForward();
    }
}
