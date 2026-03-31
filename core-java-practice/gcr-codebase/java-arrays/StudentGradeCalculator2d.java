import java.util.Scanner;

class StudentGradeCalculator2d {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Arrays to store data
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            marks[i][0] = input.nextInt();

            if (marks[i][0] < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;
                continue;
            }

            System.out.print("Chemistry: ");
            marks[i][1] = input.nextInt();

            if (marks[i][1] < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;
                continue;
            }

            System.out.print("Maths: ");
            marks[i][2] = input.nextInt();

            if (marks[i][2] < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;
                continue;
            }

            // Calculate percentage
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            // Assign grade
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'F';
            }
        }

        // Display results
        System.out.println("\n----- Student Report -----");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        input.close();
    }
}
