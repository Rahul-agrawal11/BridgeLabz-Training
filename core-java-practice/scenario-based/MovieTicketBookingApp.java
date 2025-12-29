import java.util.Scanner;

public class MovieTicketBookingApp {

    // Fixed prices
    static final int GOLD_PRICE = 150;
    static final int SILVER_PRICE = 100;
    static final int SNACKS_PRICE = 50;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            int totalBill = 0; // reset bill for every booking

            System.out.print("Enter Movie Type (action/comedy/horror/romance) or exit: ");
            String movieType = input.next().toLowerCase();

            if (movieType.equals("exit")) {
                System.out.println("Thank you for the visit.");
                break;
            }

            int movieCharge = getMovieCharge(movieType);
            if (movieCharge == -1) {
                System.out.println("Invalid movie type.");
                continue;
            }

            totalBill += movieCharge;

            System.out.print("Enter seat type (gold/silver): ");
            String seatType = input.next().toLowerCase();
            int seatCharge = getSeatCharge(seatType);

            if (seatCharge == -1) {
                System.out.println("Invalid seat type.");
                continue;
            }

            totalBill += seatCharge;

            System.out.print("Do you want snacks (yes/no): ");
            String snacks = input.next().toLowerCase();
            int snacksCharge = getSnacksCharge(snacks);

            totalBill += snacksCharge;

            // Final Bill Summary
            System.out.println("\n--------- BILL SUMMARY ---------");
            System.out.println("Movie Type      : " + movieType);
            System.out.println("Movie Charge    : " + movieCharge);
            System.out.println("Seat Type       : " + seatType);
            System.out.println("Seat Charge     : " + seatCharge);
            System.out.println("Snacks Charge   : " + snacksCharge);
            System.out.println("Final Bill      : " + totalBill);
            System.out.println("--------------------------------\n");
        }

        input.close();
    }

    // Returns movie charge
    static int getMovieCharge(String movieType) {
        switch (movieType) {
            case "action":  return 30;
            case "comedy":  return 35;
            case "horror":  return 40;
            case "romance": return 50;
            default:        return -1;
        }
    }

    // Returns seat charge
    static int getSeatCharge(String seatType) {
        if (seatType.equals("gold")) {
            return GOLD_PRICE;
        } else if (seatType.equals("silver")) {
            return SILVER_PRICE;
        }
        return -1;
    }

    // Returns snacks charge
    static int getSnacksCharge(String snacks) {
        return snacks.equals("yes") ? SNACKS_PRICE : 0;
    }
}