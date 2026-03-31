package streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterStreams {

    // Method to convert uppercase letters to lowercase while copying file
    public static void upperToLower(String readPath, String writePath) throws IOException {

        // BufferedReader for efficient reading of characters
        try (BufferedReader br = new BufferedReader(new FileReader(readPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(writePath))) {

            int ch;

            // Read character by character
            while ((ch = br.read()) != -1) {

                // Convert character to lowercase
                char lowerChar = Character.toLowerCase((char) ch);

                // Write converted character to output file
                bw.write(lowerChar);
            }

            System.out.println("Data converted successfully (Uppercase → Lowercase).");
        }
    }

    public static void main(String[] args) {

        String readPath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\ConsoleFile.txt";
        String writePath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\UpperToLower.txt";

        try {
            upperToLower(readPath, writePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}