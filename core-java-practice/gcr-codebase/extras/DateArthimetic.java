import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class DateArthimetic {
    
    public static void main(String[] args) {
        
        // Taking user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter date(dd-MM-yyyy): ");
        String inputDate = input.nextLine();
        
        // Format date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, formatter);
        
        // To plus 7 days
        LocalDate toPlusDays = date.plusDays(7);
        
        // To plus 1 months
        LocalDate toPlusMonths = toPlusDays.plusMonths(1);
        
        // To plus 2 years
        LocalDate toPlusYears = toPlusMonths.plusYears(2);
        
        // To minus 3 weeks
        LocalDate toMinusWeeks = toPlusYears.minusWeeks(3);

        // Display Final Date
        System.out.println("Final Calculated Date: "+ toMinusWeeks);
    }
}