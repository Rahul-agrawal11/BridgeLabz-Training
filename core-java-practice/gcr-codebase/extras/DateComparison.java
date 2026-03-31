import java.time.*;
import java.time.format.DateTimeFormatter;                       
import java.util.Scanner; 

class DateComparison {

    public static void main(String[] args) {

        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the first date
        System.out.print("Enter First Date (dd-MM-yyyy): ");
        String inputDate1 = input.nextLine();

        // Ask the user to enter the second date
        System.out.print("Enter Second Date (dd-MM-yyyy): ");
        String inputDate2 = input.nextLine();

        // Define the date format for parsing input strings
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Convert input strings into LocalDate objects
        LocalDate date1 = LocalDate.parse(inputDate1, formatter);
        LocalDate date2 = LocalDate.parse(inputDate2, formatter);

        // Compare the two dates and display the result
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is after " + date2);
        } else if (date1.isEqual(date2)) {
            System.out.println(date1 + " is equal to " + date2);
        }

        // Close the Scanner to free resources
        input.close();
    }
}
