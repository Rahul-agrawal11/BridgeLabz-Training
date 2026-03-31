import java.util.Scanner;

class BodyMassIndex {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of persons: ");
		int number = input.nextInt();
		
		double[] weight = new double[number];
		double[] heights = new double[number];
		double[] BMI = new double[number];
		String[] weightStatus = new String[number];
		
		for (int index = 0; index < number; index++) {
			System.out.print("Enter " + (index + 1) + " person weight: ");
			weight[index] = input.nextDouble();
			System.out.print("Enter " + (index + 1) + " person heights: ");
			double height = input.nextDouble();
			height = height * 0.01;
			heights[index] = height;
		}
		
		for (int index = 0; index < number; index++) {
			BMI[index] = weight[index] / (heights[index] * heights[index]);
			if (BMI[index] <= 18.5) {
				weightStatus[index] = "Category: Underweight";
			} else if (BMI[index] < 25) {
				weightStatus[index] = "Category: Normal";
			} else if (BMI[index] < 40) {
				weightStatus[index] = "Category: Overweight";
			} else {
				weightStatus[index] = "Category: Obese";
			}
		}
		System.out.println("Person\t\tWeight\t\tHeight(inch)\t\tBMI\t\t\t Weight Status");
		
		for (int index = 0; index < number; index++) {
			System.out.println((index + 1) + "\t\t" + weight[index] + "\t\t" +heights[index] + "\t\t" +BMI[index] + "\t\t" +weightStatus[index]);
		}
	}
}