import java.util.Scanner;

public class StudentVoteChecker {

	public static boolean canStudentVote(int age) {
		if (age < 18) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = 10;
		int[] studentAge = new int[number];
		
		for (int i = 0; i < number; i++) {
			System.out.print("Enter Student " + (i + 1) + " age : ");
			studentAge[i] = input.nextInt();
		}
		
		for (int i = 0; i < number; i++) {
			if (canStudentVote(studentAge[i])) {
				System.out.println("Student " + (i + 1) + " can vote.");
			} else {
				System.out.println("Student " + (i + 1) + " cannot vote.");
			}
		}
	}
}