import java.util.Scanner;

class BMICalculator {
	
	// Method to calculate BMI and Status
	public static String[][] toCalculateBMI(double[][] weightHeight) {
		String[][] bmiWithStatus = new String[10][2];
		
		for (int i = 0; i < 10; i++) {
			
			// Convert height inches to cms
			double height = weightHeight[i][1] * 0.01;
			double bmi = weightHeight[i][0] / (height * height);
			
			// Store bmi as string
			String bmiS = String.valueOf(bmi);
			bmiWithStatus[i][0] = bmiS;
			
			// Check Status
			if (bmi <= 18.5) {
				bmiWithStatus[i][1] = "Underweight";
			} else if (bmi < 25) {
				bmiWithStatus[i][1] = "Normal";
			} else if (bmi < 40) {
				bmiWithStatus[i][1] = "Overweight";
			} else {
				bmiWithStatus[i][1] = "Obese";
			}
		}
		return bmiWithStatus;
	}
	
	// Returns Person's BMI details in String array
	public static String[][] takeWeightHeight(double[][] weightHeight) {
		String[][] finalResult = new String[10][4];
		String[][] bmiWithStatus = toCalculateBMI(weightHeight);
		
		// Convert Double type numbers into String
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
		
		// Take user input for weight and height
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter weight for Person " + (i + 1) + " : ");
			double weight = input.nextDouble();
			
			// check for positive weight
			if (weight < 1) {
				System.out.print("Enter positive weight: ");
				i--;
			}
			weightHeight[i][0] = weight;
			
			System.out.print("Enter height for Person " + (i + 1) + " : ");
			double height = input.nextDouble();
			
			// check for positive height
			if (height < 1) {
				System.out.print("Enter positive height: ");
				i--;
			}
			weightHeight[i][1] = height;
		}
		
		String[][] finalResult = takeWeightHeight(weightHeight);
		
		// Display the user's BMI details
		System.out.println("Weight\tHeight\tBMI\t\t\tStatus");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(finalResult[i][0] + "\t");
			System.out.print(finalResult[i][1] + "\t");
			System.out.print(finalResult[i][2] + "\t");
			System.out.print(finalResult[i][3] + "\t");
			System.out.println();
		}
	}
}