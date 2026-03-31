package streams;

// Import required classes for file handling and buffered streams
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedStreams {

    // Method to copy file using normal streams (unbuffered)
    public static long usingNormalStreams(String readPath, String writePath) throws IOException {

        long startTime = System.nanoTime(); // Start time

        // Try-with-resources ensures automatic closing of streams
        try (FileInputStream fin = new FileInputStream(readPath);
             FileOutputStream fout = new FileOutputStream(writePath)) {

            int content; // Variable to store each byte read from file

            // Read and write byte by byte
            while ((content = fin.read()) != -1) {
                fout.write(content);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime(); // End time
        return endTime - startTime; // Return execution time
    }

    // Method to copy file using buffered streams (buffer size = 4KB)
    public static long usingBufferStreams(String readPath, String writePath) throws IOException {

        long startTime = System.nanoTime(); // Start time

        // Buffered streams for efficient I/O operations
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(readPath));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(writePath))) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;

            // Read and write data in chunks of 4KB
            while ((bytesRead = bin.read(buffer)) != -1) {
                bout.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime(); // End time
        return endTime - startTime; // Return execution time
    }

    public static void main(String[] args) {

        // Source file path (large file ~100MB)
        String readPath = "D:\\Users\\itz_r\\Downloads\\100mb-examplefile-com.txt";

        // Destination file paths
        String writePath1 = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\WrittenByNormal.txt";
        String writePath2 = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\WrittenByBuffer.txt";

        try {
            long normalTime = usingNormalStreams(readPath, writePath1);
            long bufferTime = usingBufferStreams(readPath, writePath2);

            System.out.println("Time taken by normal streams (ns): " + normalTime);
            System.out.println("Time taken by buffered streams (ns): " + bufferTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}