import java.util.Scanner;

public class LineComparisonComUC2 {

    // Method to calculate line length
    static Double calculateLength(int x1, int y1, int x2, int y2) {
        double length = Math.sqrt(
                Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2)
        );
        return length; // auto-boxing to Double
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // First Line Coordinates
        System.out.println("Enter coordinates for first line:");

        System.out.print("Enter x1: ");
        int l1x1 = input.nextInt();

        System.out.print("Enter y1: ");
        int l1y1 = input.nextInt();

        System.out.print("Enter x2: ");
        int l1x2 = input.nextInt();

        System.out.print("Enter y2: ");
        int l1y2 = input.nextInt();

        // Second Line Coordinates
        System.out.println("\nEnter coordinates for second line:");

        System.out.print("Enter x1: ");
        int l2x1 = input.nextInt();

        System.out.print("Enter y1: ");
        int l2y1 = input.nextInt();

        System.out.print("Enter x2: ");
        int l2x2 = input.nextInt();

        System.out.print("Enter y2: ");
        int l2y2 = input.nextInt();

        // Calculate lengths
        Double line1Length = calculateLength(l1x1, l1y1, l1x2, l1y2);
        Double line2Length = calculateLength(l2x1, l2y1, l2x2, l2y2);

        // Compare using equals()
        if (line1Length.equals(line2Length)) {
            System.out.println("\nBoth lines are EQUAL in length");
        } else {
            System.out.println("\nBoth lines are NOT equal in length");
        }

        input.close();
    }
}

// LineComparisonComUC2.java(END)