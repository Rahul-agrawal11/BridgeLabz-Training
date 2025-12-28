import java.time.*;
import java.time.format.DateTimeFormatter;

class DateFormatting {
    
    public static void main(String[] args) {
        
        // Get the current date (year, month, day)
        LocalDate today = LocalDate.now();
        
        // Formatter for date in dd/MM/yyyy format
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Formatter for date in yyyy-MM-dd format
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Formatter for a readable date format with day and month names
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Format the current date using different patterns       
        String formattedDate1 = today.format(formatter1);
        String formattedDate2 = today.format(formatter2);
        String formattedDate3 = LocalDate.now().format(formatter3);
        
        // Display Formatted Dates
        System.out.println("Format (dd/MM/yyyy): " + formattedDate1);
        System.out.println("Format (yyyy-MM-dd): " + formattedDate2);
        System.out.println("Format (EEE, MMM dd, yyyy): " + formattedDate3);   
    }
}