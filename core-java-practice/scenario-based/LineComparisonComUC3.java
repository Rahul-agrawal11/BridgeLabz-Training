import java.util.Scanner;

public class LineComparisonComUC3 {

    // Method to calculate line length
    static Double calculateLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2)
        );
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

        // Compare using compareTo()
        int result = line1Length.compareTo(line2Length);

        if (result == 0) {
            System.out.println("\nBoth lines are EQUAL in length");
        } else if (result > 0) {
            System.out.println("\nLine 1 is GREATER than Line 2 in length");
        } else {
            System.out.println("\nLine 2 is GREATER than Line 1 in length");
        }

        input.close();
    }
}
