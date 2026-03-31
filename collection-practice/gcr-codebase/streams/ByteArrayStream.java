package streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {

    public static void convertImageToByteArray(String inputPath, String outputPath) throws IOException {

        // Step 1: Read image file into byte array using FileInputStream
        FileInputStream fis = new FileInputStream(inputPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;

        // Read file and write into ByteArrayOutputStream
        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        // Convert ByteArrayOutputStream to byte array
        byte[] imageBytes = baos.toByteArray();

        fis.close();
        baos.close();

        System.out.println("Image converted to byte array successfully!");

        // Step 2: Convert byte array back to image using ByteArrayInputStream
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream(outputPath);

        // Write byte array into new image file
        while ((bytesRead = bais.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        bais.close();
        fos.close();

        System.out.println("New image file created successfully!");

        // Step 3: Verify file size (basic verification)
        File originalFile = new File(inputPath);
        File newFile = new File(outputPath);

        if (originalFile.length() == newFile.length()) {
            System.out.println("Verification Passed: Files are identical (same size).");
        } else {
            System.out.println("Verification Failed: Files are different.");
        }
    }

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\lotus.jpg";
        String outputPath = "C:\\Users\\itz_r\\eclipse-workspace\\collection_practice\\src\\streams\\lotus_copy.jpg";

        try {
            convertImageToByteArray(inputPath, outputPath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
