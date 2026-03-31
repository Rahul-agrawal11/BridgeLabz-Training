package csvHandling;

import java.util.regex.*;
import java.io.*;

public class ValidateCSVData {

    static boolean validEmail(String input) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return input.matches(regex);
    }

    static boolean validNumber(String input) {
        String regex = "^[789]\\d{9}$";
        return input.matches(regex);
    }

    public static void main(String[] args) {

        String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\data.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (!validEmail(data[0]) || !validNumber(data[1])) {
                    System.out.println("Invalid details → " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
