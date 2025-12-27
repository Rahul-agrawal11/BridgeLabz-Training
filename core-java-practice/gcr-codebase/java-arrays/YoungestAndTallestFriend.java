import java.util.Scanner;

class YoungestAndTallestFriend {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] name = {"Amar", "Akbar", "Anthony"};
		int[] age = new int[3];
		double[] height = new double[3];
		
		// User input for age and height
		for (int index = 0; index < 3; index++) {
			System.out.println("Enter Age of friend " + (index + 1));
			age[index] = input.nextInt();
			System.out.println("Enter height of friend " + (index + 1));
			height[index] = input.nextDouble();
		}
		
		int youngest = Integer.MAX_VALUE;
		double tallest = Integer.MIN_VALUE;
		int index = 0;
		int tallIndex = 0;
		int heightIndex = 0;
		
		// Check for youngest and tallest friend
		while (index < 3) {
			if (youngest > age[index]) {
				youngest = age[index];
				heightIndex++;
			}
			if (tallest < height[index]) {
				tallest = height[index];
				tallIndex++;
			}
			index++;
		}
		
		// Print Youngest and Tallest friend
		System.out.println("The Youngest friend is: " + name[heightIndex-1] + " and the Tallest friend is: " + name[tallIndex-1]);
		
	}
}