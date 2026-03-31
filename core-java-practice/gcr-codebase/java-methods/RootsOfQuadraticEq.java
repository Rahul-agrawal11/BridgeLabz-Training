import java.util.Scanner;

public class RootsOfQuadraticEq {

    // Method to calculate discriminant (delta)
    public static double valueOfDelta(int a, int b, int c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        return delta;
    }

    // Method to find roots
    public static double[] findRoots(int a, int b, int c) {
        double delta = valueOfDelta(a, b, c);

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } 
        else if (delta == 0) {
            double root = (-b) / (2.0 * a);
            return new double[]{root};
        } 
        else {
            // No real roots
            return new double[]{};
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        int a = input.nextInt();

        System.out.print("Enter value of b: ");
        int b = input.nextInt();

        System.out.print("Enter value of c: ");
        int c = input.nextInt();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 2) {
            System.out.println("Roots are real and different:");
            System.out.println("Root 1 = " + roots[0]);
            System.out.println("Root 2 = " + roots[1]);
        } 
        else if (roots.length == 1) {
            System.out.println("Roots are real and same:");
            System.out.println("Root = " + roots[0]);
        } 
        else {
            System.out.println("Roots are imaginary (No real roots).");
        }

        input.close();
    }
}