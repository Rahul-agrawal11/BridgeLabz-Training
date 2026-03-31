package HotelReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Guest> guests = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        // Pricing strategies
        PricingStrategy regular = new RegularPricing();
        PricingStrategy seasonal = new SeasonalPricing(0.20);

        // Rooms
        rooms.add(new StandardRoom(101, 1000, true, regular));
        rooms.add(new DeluxeRoom(201, 2000, true, seasonal));

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Add Guest");
            System.out.println("3. Book Room");
            System.out.println("4. Check-In");
            System.out.println("5. Check-Out");
            System.out.println("6. View Reservations");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // READ rooms
                case 1:
                    for (Room r : rooms) {
                        r.displayRoomDetails();
                        System.out.println("------------------");
                    }
                    break;

                // CREATE guest
                case 2:
                    System.out.print("Enter Guest ID: ");
                    int gid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Guest Name: ");
                    String gname = sc.nextLine();

                    Guest guest = new Guest(gid, gname);
                    guests.add(guest);
                    System.out.println("Guest added successfully!");
                    break;

                // CREATE reservation (Book room)
                case 3:
                    System.out.print("Enter Guest ID: ");
                    int guestId = sc.nextInt();

                    Guest foundGuest = null;
                    for (Guest g : guests) {
                        if (g.getId() == guestId) {
                            foundGuest = g;
                            break;
                        }
                    }

                    if (foundGuest == null) {
                        System.out.println("Guest not found!");
                        break;
                    }

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    Room foundRoom = null;
                    for (Room r : rooms) {
                        if (r.getRoomNum() == roomNo) {
                            foundRoom = r;
                            break;
                        }
                    }

                    if (foundRoom == null) {
                        System.out.println("Room not found!");
                        break;
                    }

                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();

                    Reservation res = new Reservation(foundGuest, foundRoom, days);
                    try {
                        res.bookRoom();
                        reservations.add(res);
                        System.out.println("Room booked successfully!");
                    } catch (RoomNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // UPDATE (Check-In)
                case 4:
                    System.out.print("Enter Reservation ID: ");
                    int ridIn = sc.nextInt();

                    for (Reservation r : reservations) {
                        if (r.getReservationId() == ridIn) {
                            r.checkIn();
                        }
                    }
                    break;

                // UPDATE + DELETE (Check-Out)
                case 5:
                    System.out.print("Enter Reservation ID: ");
                    int ridOut = sc.nextInt();

                    for (Reservation r : reservations) {
                        if (r.getReservationId() == ridOut) {
                            r.checkOut();
                        }
                    }
                    break;

                // READ reservations
                case 6:
                    for (Reservation r : reservations) {
                        r.displayReservationDetails();
                        System.out.println("------------------");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using Hotel Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
