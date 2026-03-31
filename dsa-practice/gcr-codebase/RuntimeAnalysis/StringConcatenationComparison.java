package RuntimeAnalysis;

import java.util.Scanner;

public class StringConcatenationComparison {

    // Concatenates strings using String (immutable)
    // Time Complexity: O(n^2) due to creation of new objects
    public static long concatenateString(String text, int n) {
        
        // Empty string to store result
        String conn_str = "";
        
        // Record start time
        long start = System.nanoTime();
        
        // Concatenate string n times
        for (int i = 0; i < n; i++) {
            conn_str += text;   // Creates a new String object each time
        }
        
        // Return time taken
        return System.nanoTime() - start;
    }

    // Concatenates strings using StringBuilder (mutable, not thread-safe)
    // Time Complexity: O(n)
    public static long concatenateStringBuilder(String text, int n) {
        
        // Pre-allocate capacity for better performance
        StringBuilder sb = new StringBuilder(n * text.length());
        
        // Record start time
        long start = System.nanoTime();
        
        // Append string n times
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        
        // Return time taken
        return System.nanoTime() - start;
    }

    // Concatenates strings using StringBuffer (mutable, thread-safe)
    // Time Complexity: O(n)
    public static long concatenateStringBuffer(String text, int n) {
        
        // Pre-allocate capacity for better performance
        StringBuffer sb = new StringBuffer(n * text.length());
        
        // Record start time
        long start = System.nanoTime();
        
        // Append string n times
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        
        // Return time taken
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        // Ask user for number of concatenations
        System.out.print("Enter number of strings: ");
        int n = input.nextInt();

        // Sample text to concatenate
        String text = "Ram ";

        // JVM warm-up to reduce first-run overhead
        concatenateStringBuilder(text, 1000);
        concatenateStringBuffer(text, 1000);

        // Measure execution times
        long t1 = concatenateString(text, n);
        long t2 = concatenateStringBuilder(text, n);
        long t3 = concatenateStringBuffer(text, n);

        // Display results in milliseconds
        System.out.println("\n--- Execution Time ---");
        System.out.println("String        : " + t1 / 1_000_000.0 + " ms");
        System.out.println("StringBuilder : " + t2 / 1_000_000.0 + " ms");
        System.out.println("StringBuffer  : " + t3 / 1_000_000.0 + " ms");

        // Close scanner resource
        input.close();
    }
}
