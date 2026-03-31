public class Student {

    // Method to calculate grade
    static char toCalculateGrade(double m1, double m2, double m3) {

        double average = (m1 + m2 + m3) / 3;

        if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else {
            return 'D';
        }
    }

    // Method to display student details
    static void displayStudentDetails(String name, String rollNo,
                                      double m1, double m2, double m3) {

        char grade = toCalculateGrade(m1, m2, m3);

        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNo);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + m1);
        System.out.println("Mark2: " + m2);
        System.out.println("Mark3: " + m3);
        System.out.println("Grade " + grade);
    }

    public static void main(String[] args) {

        // First Student
        displayStudentDetails(
                "Thamarai", "ECE001",
                80.0, 70.0, 75.0
        );

        // Second Student
        displayStudentDetails(
                "Kannan", "CSC002",
                60.0, 65.0, 50.0
        );
    }
}