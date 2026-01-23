package collections.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFrequencyCounter {

    public static HashMap<String, Integer> countWords(String filePath) {
        HashMap<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");

                // Split words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\Sample.txt"; // file path
        System.out.println(countWords(filePath));
    }
}
