package javaSearchingStringIoPractice;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StreamComparison {

    // FileReader approach
    public static Result readWithFileReader(String path) throws IOException {

        long start = System.nanoTime();
        long wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    wordCount += line.split("\\s+").length;
                }
            }
        }

        long end = System.nanoTime();
        return new Result(wordCount, end - start);
    }

    // InputStreamReader approach
    public static Result readWithInputStreamReader(String path) throws IOException {

        long start = System.nanoTime();
        long wordCount = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path),
                        StandardCharsets.UTF_8))) {

            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    wordCount += line.split("\\s+").length;
                }
            }
        }

        long end = System.nanoTime();
        return new Result(wordCount, end - start);
    }

    public static void main(String[] args) throws IOException {

        String path = "D:\\Users\\itz_r\\Downloads\\100mb-examplefile-com.txt";

        Result fileReaderResult = readWithFileReader(path);
        Result inputStreamReaderResult = readWithInputStreamReader(path);

        System.out.println("FileReader:");
        System.out.println("Words = " + fileReaderResult.wordCount);
        System.out.println("Time (ns) = " + fileReaderResult.time);

        System.out.println("\nInputStreamReader:");
        System.out.println("Words = " + inputStreamReaderResult.wordCount);
        System.out.println("Time (ns) = " + inputStreamReaderResult.time);
    }
}

// Helper class to return multiple values
class Result {
    long wordCount;
    long time;

    Result(long wordCount, long time) {
        this.wordCount = wordCount;
        this.time = time;
    }
}