import java.util.Scanner;

// Custom Exception
class InvalidScoreException extends Exception {
    InvalidScoreException(String message) {
        super(message);
    }
}

// Utility class for validation
class ScoreValidator {
    public static int validateScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException(
                "Invalid score: " + score + ". Score must be between 0 and 100."
            );
        }
        return score;
    }
}

class StudentScoreAnalyzer {

    // Calculate average score
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // Find highest score
    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // Find lowest score
    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalStudents = 10;
        int[] studentScores = new int[totalStudents];

        System.out.println("Enter Math exam scores:");

        for (int i = 0; i < totalStudents; i++) {
            while (true) {
                try {
                    System.out.print("Score of student " + (i + 1) + ": ");
                    int score = input.nextInt();
                    studentScores[i] = ScoreValidator.validateScore(score);
                    break; // valid input → move to next student
                } catch (InvalidScoreException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    input.next(); // clear invalid input
                }
            }
        }

        double average = calculateAverage(studentScores);
        int highest = findMax(studentScores);
        int lowest = findMin(studentScores);

        System.out.println("\n--- Exam Analysis ---");
        System.out.println("Average Score : " + average);
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score  : " + lowest);
    }
}
