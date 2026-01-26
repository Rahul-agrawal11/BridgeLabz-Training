package streams;

// Import required classes for input and output operations
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {

    // Method to write user data into a file
    public static void writeData(String name, int age, String language) throws IOException {

        // File path where data will be stored
        String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\ConsoleFile.txt";

        // Try-with-resources ensures FileWriter is automatically closed
        try (FileWriter fw = new FileWriter(filePath)) {

            // Writing user details into the file
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Language: " + language + "\n");
        }

        // Confirmation message after successful file write
        System.out.println("Data inserted successfully!");
    }

    public static void main(String[] args) {

        // BufferedReader is used to read input from the console
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // Ask user to enter name
            System.out.print("Enter your name: ");
            String name = br.readLine();

            // Ask user to enter age
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine()); // Convert String input to integer

            // Ask user to enter favorite programming language
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Call method to write data into file
            writeData(name, age, language);

        }
        // Handle invalid number format exception
        catch (NumberFormatException e) {
            System.out.println("Invalid age! Please enter a number.");
        }
        // Handle input/output exceptions
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}