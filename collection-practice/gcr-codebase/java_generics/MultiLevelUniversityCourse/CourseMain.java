package java_generics.MultiLevelUniversityCourse;

import java.util.Scanner;

public class CourseMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        // Course containers
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        while (true) {

            System.out.println("\n====== University Course Management System ======");
            System.out.println("1. Add Exam-Based Course");
            System.out.println("2. Add Assignment-Based Course");
            System.out.println("3. Add Research-Based Course");
            System.out.println("4. Display All Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    examCourses.addCourse(new ExamCourse("MCA", 2));
                    examCourses.addCourse(new ExamCourse("BCA", 3));
                    System.out.println("Exam-based courses added");
                    break;

                case 2:
                    assignmentCourses.addCourse(
                        new AssignmentCourse("Java Internship", 1)
                    );
                    assignmentCourses.addCourse(
                        new AssignmentCourse("Python Internship", 1)
                    );
                    System.out.println("Assignment-based courses added");
                    break;

                case 3:
                    researchCourses.addCourse(
                        new ResearchCourse("Ph.D", 3)
                    );
                    System.out.println("Research-based course added");
                    break;

                case 4:
                    Utility.displayCourses(examCourses.getCourses());

                    Utility.displayCourses(assignmentCourses.getCourses());

                    Utility.displayCourses(researchCourses.getCourses());
                    break;

                case 5:
                    System.out.println("Exiting University Course System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
