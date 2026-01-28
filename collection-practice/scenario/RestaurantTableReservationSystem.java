package scenario;

import java.util.*;

class Table {
	int tableNumber;
	int seats;
	
	public Table(int tableNumber, int seats) {
		this.tableNumber = tableNumber;
		this.seats = seats;
	}
}

class Reservation {
	int tableNumber;
	String name;
	String timeSlot;
	
	public Reservation(int tableNumber, String name, String timeSlot) {
		this.tableNumber = tableNumber;
		this.name = name;
		this.timeSlot = timeSlot;
	}
}

class TableAlreadyReservedException extends Exception {
	TableAlreadyReservedException(String msg) {
		super(msg);
	}
}

public class RestaurantTableReservationSystem {
	
	static HashMap<Integer, Table> tableMap = new HashMap<>();
	static List<Reservation> reservations = new ArrayList<>();
	
	
	// Reserve Table
	static boolean reserveTable(int tableNumber, String name, String timeSlot) throws TableAlreadyReservedException {
		if(!tableMap.containsKey(tableNumber)) {
			System.out.println("Table does not exist!");
            return false;
		}
		
		for (Reservation r : reservations) {
			if(r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
				throw new TableAlreadyReservedException("Table " + tableNumber + " already reserved for " + timeSlot);
			}
		}
		reservations.add(new Reservation(tableNumber, name, timeSlot));
		return true;
	}
	
	// Cancel Reservation
	static boolean cancelReservation(int tableNumber, String timeSlot) {
		Iterator<Reservation> it = reservations.iterator();
		
		while(it.hasNext()) {
			Reservation r = it.next();
			if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                it.remove();
                return true;
            }
		}
		return false;
	}
	
	// Show available tables
	static List<Integer> showAvailableTables(String timeSlot) {
		List<Integer> availableTables = new ArrayList<>();
		
		for (int tableNumber : tableMap.keySet()) {
			boolean reserved = false;

            for (Reservation r : reservations) {
                if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                    reserved = true;
                    break;
            }
		}
        
            if (!reserved) {
            	availableTables.add(tableNumber);
            }
		}
		return availableTables;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Add tables
        tableMap.put(1, new Table(1, 4));
        tableMap.put(2, new Table(2, 6));
        tableMap.put(3, new Table(3, 2));
        
        while (true) {
            System.out.println("\n===== Restaurant Reservation System =====");
            System.out.println("1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
            case 1:
                try {
                    System.out.print("Enter Table Number: ");
                    int tableNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Time Slot (e.g. 7PM-8PM): ");
                    String timeSlot = sc.nextLine();

                    boolean success = reserveTable(tableNo, name, timeSlot);
                    if (success) {
                        System.out.println("Table reserved successfully!");
                    }

                } catch (TableAlreadyReservedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("Enter Table Number: ");
                int tableNo = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Time Slot: ");
                String timeSlot = sc.nextLine();

                boolean cancelled = cancelReservation(tableNo, timeSlot);
                if (cancelled) {
                    System.out.println("Reservation cancelled!");
                } else {
                    System.out.println("Reservation not found!");
                }
                break;

            case 3:
                System.out.print("Enter Time Slot: ");
                String slot = sc.nextLine();

                List<Integer> available = showAvailableTables(slot);
                if (available.isEmpty()) {
                    System.out.println("No tables available!");
                } else {
                    System.out.println("Available Tables: " + available);
                }
                break;

            case 4:
                System.out.println("Exiting system...");
                sc.close();
                return;

            default:
                System.out.println("Invalid choice!");
            }
        }
	}
}
