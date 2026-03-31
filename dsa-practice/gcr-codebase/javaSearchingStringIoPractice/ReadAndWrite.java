package javaSearchingStringIoPractice;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;

public class ReadAndWrite {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\itz_r\\eclipse-workspace\\Sample.txt");

        try (
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer =
                new FileWriter(file, true)   // append mode
        ) {

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Input stopped.");
                    break;
                }

                writer.write(input);
                writer.write(System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}