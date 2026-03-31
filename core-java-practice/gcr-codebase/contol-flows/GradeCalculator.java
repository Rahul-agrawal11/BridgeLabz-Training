/* Write a program to input marks and 3 subjects physics, chemistry and maths. 
Compute the percentage and then calculate the grade as per the following guidelines */

import java.util.Scanner;

class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int physicsMark = input.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chemistryMark = input.nextInt();
        System.out.print("Enter Maths marks: ");
        int mathsMark = input.nextInt();
        int totalMarks = physicsMark + chemistryMark + mathsMark;
        double percentage = (totalMarks * 100.0) / 300.0;

        if (physicsMark > 100 || chemistryMark > 100 || mathsMark > 100) {
            System.out.println("Numbers should not be greater than 100.");
        } else {
            System.out.println("Grade                Remarks                                   Marks");
            if (percentage >= 80) {
                System.out.println("  A       (Level 4, above agency-normalized standards)   " + percentage);
            } else if (percentage >= 70 && percentage < 80) {
                System.out.println("  B       (Level 3, agency-normalized standards)   " + percentage);
            } else if (percentage >= 60 && percentage < 70) {
                System.out.println("  C       (Level 2, below, but approaching agency-normalized standards)   " + percentage);
            } else if (percentage >= 50 && percentage < 60) {
                System.out.println("  D       (Level 1, well below agency-normalized standards)   " + percentage);
            } else if (percentage >= 40 && percentage < 50) {
                System.out.println("  E       (Level 1-, too below agency-normalized standards)   " + percentage);
            } else {
                System.out.println("  R           (Remedical standards)                  " + percentage);
            }
        }
        input.close();
    }
}
