import java.util.Scanner;

class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Arrays to store data
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            physics[i] = input.nextInt();

            if (physics[i] < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;
                continue;
            }

            System.out.print("Chemistry: ");
            chemistry[i] = input.nextInt();

            if (chemistry[i] < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;
                continue;
            }

            System.out.print("Maths: ");
            maths[i] = input.nextInt();

            if (maths[i] < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;
                continue;
            }

            // Calculate percentage
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

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
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Maths: " + maths[i]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        input.close();
    }
}
