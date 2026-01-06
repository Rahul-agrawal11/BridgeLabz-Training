import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class InvalidMarkException extends Exception {
    InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    Student(String name, String[] subjects, int[] marks) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }
}

class ReportGenerator {
    static List<Student> students = new ArrayList<>();

    // Validate marks
    public static void validateMarks(int[] marks) throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid Score: Marks must be between 0 and 100");
            }
        }
    }

    // Calculate average
    public static double calculateAverage(int[] marks) throws InvalidMarkException {
        validateMarks(marks);
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    // Grade calculation
    public static String gradeCalculation(double average) {
        if (average >= 85) return "A";
        else if (average >= 70) return "B";
        else if (average >= 50) return "C";
        else return "Fail";
    }

    // Add student
    public static boolean addStudent(Student s) {
        students.add(s);
        return true;
    }

    // Display report card
    public static void displayReport(Student s) throws InvalidMarkException {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Report Card -----\n");
        sb.append("Name: ").append(s.getName()).append("\n\n");
        String[] subjects = s.getSubjects();
        int[] marks = s.getMarks();

        for (int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i]).append(" : ").append(marks[i]).append("\n");
        }

        double avg = calculateAverage(marks);
        String grade = gradeCalculation(avg);

        sb.append("\nAverage : ").append(String.format("%.2f", avg));
        sb.append("\nGrade   : ").append(grade);
        sb.append("\n-----------------------\n");
        System.out.println(sb);
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            String[] subjects = new String[n];
            int[] marks = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter subject " + (i + 1) + ": ");
                subjects[i] = sc.nextLine();
                System.out.print("Enter marks for " + subjects[i] + ": ");
                marks[i] = sc.nextInt();
                sc.nextLine(); // consume newline
            }

            // Create Student object
            Student student = new Student(name, subjects, marks);

            // Add student to list using the method from ReportGenerator class
            ReportGenerator.addStudent(student);

            // Display report card using the method from ReportGenerator class
            ReportGenerator.displayReport(student);

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}