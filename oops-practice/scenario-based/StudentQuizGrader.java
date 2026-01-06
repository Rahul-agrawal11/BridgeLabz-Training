import java.util.Scanner;

public class StudentQuizGrader {

	public static int calculateScore(String[] correctAnswers, String[] studentAnswers) {
		int score = 0;
		
		for (int i = 0; i < correctAnswers.length; i++) {
			if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
				score++;
			}
		}
		return score;
	}
	
	public static void detailedFeedback(String[] correctAnswers, String[] studentAnswers) {
		
		for (int i = 0; i < correctAnswers.length; i++) {
			if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
				System.out.println("Question " + (i + 1) + ": Correct ");
			} else {
				System.out.println("Question " + (i + 1) + ": Incorrect ");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double totalScore = 10;
		
		String[] correctAnswers = {"A", "B", "D", "C", "B", "A", "B", "C", "B", "D"};
		String[] studentAnswers = new String[10];
		
		System.out.println("Enter answers(A/B/C/D): ");
		for (int i = 0; i < 10; i++) {
			System.out.print("Answer for " + (i+1) + " question: ");
			studentAnswers[i] = input.next();
		}
		
		detailedFeedback(correctAnswers, studentAnswers);
		int getScore = calculateScore(correctAnswers, studentAnswers);
		
		double percentage = (double)getScore * 100 / totalScore;
		
		if (percentage >= 40) {
			System.out.println("Percentage: " + percentage + "\nYou are passed.");
		} else {
			System.out.println("Percentage: " + percentage + "\nYou are failed");
		}
	}
}