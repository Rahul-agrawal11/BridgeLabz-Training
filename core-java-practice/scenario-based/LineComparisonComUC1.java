import java.util.Scanner;

public class LineComparisonComUC1 {
	public static void main(String[] args) {
		
		// User Input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter co-ordinates: ");
		
		System.out.print("Enter x1: ");
		int x1 = input.nextInt();
		
		System.out.print("Enter y1: ");
		int y1 = input.nextInt();
		
		System.out.print("Enter x2: ");
		int x2 = input.nextInt();
		
		System.out.print("Enter y2: ");
		int y2 = input.nextInt();
		
		// Computation for calculate length
		double length_of_a_line = Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
		
		// Display 
		System.out.println("Two co-ordinates points: (" + x1 + "," + y1 + ")" + " and (" + x2 + "," + y2 + ")");
		System.out.println("The length of a line is: " + length_of_a_line);
		
		input.close();
	}
}

// LineComparisonComUC1.java(END)