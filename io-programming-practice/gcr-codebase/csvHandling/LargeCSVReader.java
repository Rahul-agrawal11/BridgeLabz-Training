package csvHandling;

import java.io.*;
import java.util.*;

public class LargeCSVReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "C:\\large-data\\bigfile.csv";
        long totalRecords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath), 1024 * 1024)) {
            
            reader.readLine();

            List<String> chunk = new ArrayList<>(CHUNK_SIZE);
            String line;

            while ((line = reader.readLine()) != null) {
                chunk.add(line);

                if (chunk.size() == CHUNK_SIZE) {
                    totalRecords += processChunk(chunk);
                    chunk.clear();   
                }
            }

            // Process remaining lines (< 100)
            if (!chunk.isEmpty()) {
                totalRecords += processChunk(chunk);
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Processes exactly one chunk
    private static int processChunk(List<String> chunk) {
       
        for (String record : chunk) {
            // Parse / validate / transform
        	// String[] columns = record.split(",");
        }

        System.out.println("Processed chunk of size: " + chunk.size());
        return chunk.size();
    }
}
