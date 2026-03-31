package ExceptionHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckedException {

    public static void readFile(String filePath) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }

            fis.close(); // close file
            System.out.println("\nContent read successfully!");

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        String filePath = "data.txt";
        readFile(filePath);
    }
}
