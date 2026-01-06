import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class InvalidQuizSubmissionException extends Exception {
    InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizResultProcessor {
    static List<Integer> scores = new ArrayList<>();

    public static void checkCorrectAnswers(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }
    }

    public static int answerComparisonAndScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        checkCorrectAnswers(correctAnswers, userAnswers);

        int score = 0;
        for (int i = 0; i < userAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    public static boolean addScore(int score) {
        scores.add(score);
        return true;
    }

    public static String gradeCalculation(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 80) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "Fail";
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            String[] correctAnswers = {"A", "B", "C", "D", "A"};
            String[] userAnswers = new String[5];

            System.out.println("Enter your answers:");
            for (int i = 0; i < 5; i++) {
                userAnswers[i] = sc.next().toUpperCase();
            }

            int score = QuizResultProcessor.answerComparisonAndScore(correctAnswers, userAnswers);
            QuizResultProcessor.addScore(score);

            String grade = QuizResultProcessor.gradeCalculation(score, correctAnswers.length);

            System.out.println("Score: " + score);
            System.out.println("Grade: " + grade);

        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
