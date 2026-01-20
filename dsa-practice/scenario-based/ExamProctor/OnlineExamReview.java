package scenario.ExamProctor;

import java.util.HashMap;
import java.util.Stack;

public class OnlineExamReview {

    private static Stack<String> questions = new Stack<>();
    private static HashMap<Integer, String> correctAnswers = new HashMap<>();

    // Add questions to stack
    public static void addQuestion() {
        questions.push("Is Java a purely object-oriented programming language?");
        questions.push("Can we overload main method?");
        questions.push("Are strings in Java mutable?");
        questions.push("Does Java support multiple inheritance of classes?");
        questions.push("Can a finally block be skipped in Java?");
    }

    // Set correct answers
    public static void setCorrectAnswers() {
        correctAnswers.put(0, "no");
        correctAnswers.put(1, "yes");
        correctAnswers.put(2, "no");
        correctAnswers.put(3, "no");
        correctAnswers.put(4, "yes");
    }

    // Get next question safely
    public static String getNextQuestion() {
        return questions.pop();
    }

    // Calculate score
    public static int calculateScore() {
        int score = 0;

        for (int i = correctAnswers.size() - 1; i >= 0; i--) {
            String correct = correctAnswers.get(i);
            String user = TakeOnlineExam.getUserAnswers().get(i);

            if (correct != null && correct.equalsIgnoreCase(user)) {
                score++;
            }
        }
        return score;
    }
}