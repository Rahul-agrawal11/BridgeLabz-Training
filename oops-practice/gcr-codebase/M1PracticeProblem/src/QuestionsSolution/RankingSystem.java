package QuestionsSolution;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
	String sname;
	String dept;
	int quiz1;
	int quiz2;
	int quiz3;

	public Student(String sname, String dept, int quiz1, int quiz2, int quiz3) {
		this.sname = sname;
		this.dept = dept;
		this.quiz1 = quiz1;
		this.quiz2 = quiz2;
		this.quiz3 = quiz3;
	}

	public String getSname() {
		return sname;
	}

	public String getDept() {
		return dept;
	}

	public int getQuiz1() {
		return quiz1;
	}

	public int getQuiz2() {
		return quiz2;
	}

	public int getQuiz3() {
		return quiz3;
	}

	public int getTotalScore() {
		return quiz1 + quiz2 + quiz3;
	}
}

public class RankingSystem {

	ArrayList<Student> list = new ArrayList<>();

	public int recordStudent(Student s) {
		list.add(s);
		System.out.println("Record Added: " + s.getSname());
		return s.getTotalScore(); // kept return as per signature
	}

	public int getDepartmentTopper(String dept) {
		if (list.isEmpty()) {
			System.out.println("No Records Available");
			return -1;
		}

		int max = Integer.MIN_VALUE;
		boolean found = false;

		// find max
		for (Student s : list) {
			if (s.getDept().equals(dept)) {
				found = true;
				max = Math.max(max, s.getTotalScore());
			}
		}

		if (!found) {
			System.out.println("Department Not Found");
			return -1;
		}

		// print all with max (in insertion order)
		for (Student s : list) {
			if (s.getDept().equals(dept) && s.getTotalScore() == max) {
				System.out.println(s.getSname() + " " + max);
			}
		}

		return max;
	}

	public int getQuizTopper(String quizName) {
		if (list.isEmpty()) {
			System.out.println("No Records Available");
			return -1;
		}

		int max = Integer.MIN_VALUE;

		// find max
		for (Student s : list) {
			if (quizName.equals("Q1"))
				max = Math.max(max, s.getQuiz1());
			else if (quizName.equals("Q2"))
				max = Math.max(max, s.getQuiz2());
			else
				max = Math.max(max, s.getQuiz3());
		}

		// print all with max
		for (Student s : list) {
			if (quizName.equals("Q1") && s.getQuiz1() == max) {
				System.out.println(s.getSname() + " " + max);
			} else if (quizName.equals("Q2") && s.getQuiz2() == max) {
				System.out.println(s.getSname() + " " + max);
			} else if (quizName.equals("Q3") && s.getQuiz3() == max) {
				System.out.println(s.getSname() + " " + max);
			}
		}

		return max;
	}

	public int processCommands(Scanner sc, int N) {

		for (int i = 0; i < N; i++) {
			String data = sc.nextLine();
			String[] d = data.split(" ");

			switch (d[0]) {

			case "Record":
				recordStudent(new Student(d[1], d[2], Integer.parseInt(d[3]), Integer.parseInt(d[4]),
						Integer.parseInt(d[5])));
				break;

			case "Top":
				if (d[1].equals("Q1") || d[1].equals("Q2") || d[1].equals("Q3")) {
					getQuizTopper(d[1]);
				} else {
					getDepartmentTopper(d[1]);
				}
				break;
			}
		}
		return 0; 
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		RankingSystem rs = new RankingSystem();
		rs.processCommands(sc, N);

		sc.close();
	}
}