class Student {

    // Static variable shared across all products
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    // Final variable
    private final int rollNumber;

    // Instance variables
    private String name;
    private char grade;

    // Constructor using this
    Student(int rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Static method to display university name
    public static void displayUniversityName() {
        System.out.println("University Name: " + universityName);
    }

    // Display student details using instanceof
    public void displayStudentDetails(Object obj) {
        if (obj instanceof Student) {
            Student.displayUniversityName();
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    // Update grade using instanceof
    public void updateGrade(Object obj, char newGrade) {
        if (obj instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    // Main method
    public static void main(String[] args) {

        // Create students
        Student student1 = new Student(101, "Hemashree", 'A');
        Student student2 = new Student(102, "Sharmila", 'B');

        // Display total students
        Student.displayTotalStudents();

        // Display details
        student1.displayStudentDetails(student1);
        student2.displayStudentDetails(student2);

        // Update grade and display again
        student2.updateGrade(student2, 'A');
        student2.displayStudentDetails(student2);
    }
}
