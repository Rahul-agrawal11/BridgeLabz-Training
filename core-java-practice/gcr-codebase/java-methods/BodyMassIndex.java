import java.util.Scanner;

public class BodyMassIndex  {
	
	public static double[][] toCalculateBMI(double[][] BMICalculation) {
		for (int i = 0; i < 10; i++) {
			BMICalculation[i][2] = BMICalculation[i][0] / (BMICalculation[i][1] * BMICalculation[i][1]);
		}
		return BMICalculation;
	}
	
	public static String[] toGetBMIStatus(double[][] BMICalculation) {
		String[] bmiStatus = new String[10];
		
		for (int i = 0; i < 10; i++) {
			if (BMICalculation[i][2] <= 18.5) {
				bmiStatus[i] = "Underweight";
			} else if (BMICalculation[i][2] < 25) {
				bmiStatus[i] = "Normal";
			} else if (BMICalculation[i][2] < 40) {
				bmiStatus[i] = "Overweight";
			} else {
				bmiStatus[i] = "Obese";
			}
		}
		return bmiStatus;
	}
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] BMICalculation = new double[10][3];
		
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter weight(in kg) for Person " + (i + 1) + " :");
			BMICalculation[i][0] = input.nextDouble();
		
			System.out.print("Enter height(in cm) for Person " + (i + 1) + " :");
			double height = input.nextDouble();
			BMICalculation[i][1] = height * 0.01;
		}
		
		double[][] BMI = toCalculateBMI(BMICalculation);
		String[] bmiStatus = toGetBMIStatus(BMICalculation);
		
		// Display Details
		System.out.println("Weight\tHeight\tBMI\t\t\tStatus");
		for (int i = 0; i < 10; i++) {
			System.out.println(BMI[i][0] + "\t" + BMI[i][1] + "\t" + BMI[i][2] + "\t" + bmiStatus[i]);
		}
	}
}