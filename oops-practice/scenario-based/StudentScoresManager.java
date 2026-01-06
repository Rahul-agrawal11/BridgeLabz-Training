import java.util.Scanner;

public class StudentScoresManager {

    // Method to input scores with validation
    public static float[] inputScores(int n, Scanner input) {
        float[] scores = new float[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                if (input.hasNextFloat()) {
                    float score = input.nextFloat();
                    if (score >= 0) {
                        scores[i] = score;
                        break;
                    } else {
                        System.out.println("Score cannot be negative. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Enter a numeric value.");
                    input.next(); // clear invalid input
                }
            }
        }
        return scores;
    }

    // Method to calculate average
    public static float calculateAverage(float[] scores) {
        float sum = 0;
        for (float score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    // Method to find highest score
    public static float findHighest(float[] scores) {
        float max = scores[0];
        for (float score : scores) {
            if (score > max) max = score;
        }
        return max;
    }

    // Method to find lowest score
    public static float findLowest(float[] scores) {
        float min = scores[0];
        for (float score : scores) {
            if (score < min) min = score;
        }
        return min;
    }

    // Method to display scores above average
    public static void displayAboveAverage(float[] scores, float average) {
        System.out.println("\nScores above average:");
        boolean found = false;
        for (float score : scores) {
            if (score > average) {
                System.out.println(score);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;

        // Input number of students
        while (true) {
            System.out.print("Enter number of students: ");
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n > 0) break;
                else System.out.println("Number of students must be positive.");
            } else {
                System.out.println("Invalid input. Enter a numeric value.");
                input.next(); // clear invalid input
            }
        }

        // Call method to input scores
        float[] scores = inputScores(n, input);

        // Call methods to calculate average, highest, lowest
        float average = calculateAverage(scores);
        float highest = findHighest(scores);
        float lowest = findLowest(scores);

        // Display results
        System.out.println("\nAverage score: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);

        // Display scores above average
        displayAboveAverage(scores, average);

        input.close();
    }
}