package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReader {

    public static void main(String[] args) {
        String filePath = "largefile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Case-insensitive check for "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}