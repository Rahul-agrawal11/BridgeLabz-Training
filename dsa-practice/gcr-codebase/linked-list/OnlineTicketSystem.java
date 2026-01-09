// Node representing a ticket
class TicketNode {

    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {

        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular Linked List for Ticket Reservation
class TicketReservationSystem {

    private TicketNode head = null;
    private TicketNode tail = null;

    // 1. Add ticket at end
    void addTicket(int ticketId, String customerName,
                   String movieName, String seatNumber,
                   String bookingTime) {

        TicketNode newNode = new TicketNode(
                ticketId, customerName, movieName, seatNumber, bookingTime);

        // If list is empty
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // circular link
            return;
        }

        // Insert at end
        tail.next = newNode;
        tail = newNode;
        tail.next = head; // maintain circular nature
    }

    // 2. Remove ticket by Ticket ID
    void removeTicket(int ticketId) {

        if (head == null) {
            System.out.println("No tickets to remove");
            return;
        }

        TicketNode current = head;
        TicketNode prev = tail;

        do {
            if (current.ticketId == ticketId) {

                // Only one ticket
                if (head == tail) {
                    head = tail = null;
                }
                // Removing head
                else if (current == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Removing tail
                else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                }
                // Removing middle node
                else {
                    prev.next = current.next;
                }

                System.out.println("Ticket " + ticketId + " removed");
                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        System.out.println("Ticket not found");
    }

    // 3. Display all tickets
    void displayTickets() {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;

        System.out.println("Booked Tickets:");
        do {
            System.out.println(
                "ID: " + temp.ticketId +
                ", Customer: " + temp.customerName +
                ", Movie: " + temp.movieName +
                ", Seat: " + temp.seatNumber +
                ", Time: " + temp.bookingTime
            );
            temp = temp.next;
        } while (temp != head);
    }

    // 4. Search ticket by Customer Name or Movie Name
    void searchTicket(String keyword) {

        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(keyword)
                || temp.movieName.equalsIgnoreCase(keyword)) {

                System.out.println(
                    "Found Ticket → ID: " + temp.ticketId +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber
                );
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching ticket found");
        }
    }

    // 5. Count total booked tickets
    int countTickets() {

        if (head == null)
            return 0;

        int count = 0;
        TicketNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

// Main class
public class OnlineTicketSystem {

    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Rahul", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Anita", "Interstellar", "B5", "10:05 AM");
        system.addTicket(103, "Aman", "Inception", "C3", "10:10 AM");

        system.displayTickets();

        System.out.println("\nSearching by Movie Name:");
        system.searchTicket("Inception");

        System.out.println("\nTotal Tickets Booked: " + system.countTickets());

        System.out.println("\nRemoving Ticket ID 102");
        system.removeTicket(102);

        system.displayTickets();
    }
}
