package FunctionalInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FunctionalInterface
interface DateFormatter {
    String format(LocalDate date);

    static DateFormatter ofPattern(String pattern) {
        return date -> date.format(DateTimeFormatter.ofPattern(pattern));
    }
}

public class DateFormatUtility {

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        DateFormatter ddMMyyyy = DateFormatter.ofPattern("dd-MM-yyyy");
        DateFormatter yyyyMMdd = DateFormatter.ofPattern("yyyy/MM/dd");
        DateFormatter fullFormat = DateFormatter.ofPattern("EEEE, dd MMM yyyy");

        System.out.println("Invoice Date (dd-MM-yyyy): " + ddMMyyyy.format(invoiceDate));
        System.out.println("Invoice Date (yyyy/MM/dd): " + yyyyMMdd.format(invoiceDate));
        System.out.println("Invoice Date (Full): " + fullFormat.format(invoiceDate));
    }
}