import java.util.Scanner;

class BMICalculator {
	
	public static String[][] toCalculateBMI(double[][] weightHeight) {
		String[][] bmiWithStatus = new String[10][2];
		
		for (int i = 0; i < 10; i++) {
			double height = weightHeight[i][1] * 0.01;
			double bmi = weightHeight[i][0] / (height * height);
			String bmiS = String.valueOf(bmi);
			bmiWithStatus[i][0] = bmiS;
			
			if (bmi <= 18.5) {
				bmiWithStatus[i][1] = "Category: Underweight";
			} else if (bmi < 25) {
				bmiWithStatus[i][1] = "Category: Normal";
			} else if (bmi < 40) {
				bmiWithStatus[i][1] = "Category: Overweight";
			} else {
				bmiWithStatus[i][1] = "Category: Obese";
			}
		}
		return bmiWithStatus;
	}

	public static String[][] takeWeightHeight(double[][] weightHeight) {
		String[][] finalResult = new String[10][4];
		String[][] bmiWithStatus = toCalculateBMI(weightHeight);
		
		for (int i = 0; i < 10; i++) {
			String weight = String.valueOf(weightHeight[i][0]);
			String height = String.valueOf(weightHeight[i][1]);
			finalResult[i][0] = weight;
			finalResult[i][1] = height;
			finalResult[i][2] = bmiWithStatus[i][0];
			finalResult[i][3] = bmiWithStatus[i][1];
		}
		return finalResult;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] weightHeight = new double[10][2];
		
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter weight for Person " + (i + 1) + " : ");
			double weight = input.nextDouble();
			if (weight < 1) {
				System.out.print("Enter positive weight: ");
				i--;
			}
			weightHeight[i][0] = weight;
			
			System.out.print("Enter height for Person " + (i + 1) + " : ");
			double height = input.nextDouble();
			if (height < 1) {
				System.out.print("Enter positive height: ");
				i--;
			}
			weightHeight[i][1] = height;
		}
		
		String[][] finalResult = takeWeightHeight(weightHeight);
		
		System.out.println("Weight\tHeight\tBMI\tStatus");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(finalResult[i][0] + "\t");
			System.out.print(finalResult[i][1] + "\t");
			System.out.print(finalResult[i][2] + "\t");
			System.out.print(finalResult[i][3] + "\t");
		}
	}
}
