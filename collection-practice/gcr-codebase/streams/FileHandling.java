package streams;

// Import classes for file input and output operations
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandling {

    // Method to copy data from one file to another
    public static void writeFile(String readPath, String writePath) throws IOException {

        // Try-with-resources ensures automatic closing of streams
        try (FileInputStream fin = new FileInputStream(readPath);
             FileOutputStream fout = new FileOutputStream(writePath)) {

            int content; // Variable to store each byte read from file

            // Read file byte by byte until end of file (-1)
            while ((content = fin.read()) != -1) {

                // Write the read byte into the destination file
                fout.write(content);
            }

            // Message after successful file copy
            System.out.println("Data copied successfully!");

        } 
        // Handle file not found exception separately
        catch (FileNotFoundException e) {
            System.out.println("Error: File path not found.");
        }
    }

    public static void main(String[] args) {

        // Source file path (file to read)
        String readPath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\File.txt";

        // Destination file path (file to write)
        String writePath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\newFile.txt";

        try {
            // Call method to copy file content
            writeFile(readPath, writePath);
        } 
        // Handle input/output exceptions
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
