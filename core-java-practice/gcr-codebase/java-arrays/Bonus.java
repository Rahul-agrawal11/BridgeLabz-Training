import java.util.Scanner;

class Bonus {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		int[] yearOfService = new int[10];
		double[] oldSalary = new double[10];
		double[] newSalary = new double[10];
		double[] bonusAmount = new double[10];
		
		
		// User Input for Year of Service
		System.out.println("Enter Year of Service: ");
		for (int index = 0; index < 10; index++) {
			yearOfService[index] = input.nextInt();
			if (yearOfService[index] < 1) {
				System.err.println("Enter the correct value: ");
				index--;
			}
		}
		
		// User Input for their current year
		System.out.println("Enter your current salary: ");
		for (int index = 0; index < 10; index++) {
			oldSalary[index] = input.nextDouble();
			if (oldSalary[index] < 1) {
				System.err.println("Enter correct salary: ");
				index--;
			}
		}
		
		// Calculating bonus and new salary
		for (int index = 0; index < 10; index++) {
			if (yearOfService[index] >= 5) {
				bonusAmount[index] = oldSalary[index] * 0.05;
				newSalary[index] = oldSalary[index] + bonusAmount[index];
			} else {
				bonusAmount[index] = oldSalary[index] * 0.02;
				newSalary[index] = oldSalary[index] + bonusAmount[index];
			}
		}
		
		// Printing the total bonus payout as well as the total old and new salary of all the employees
		for (int index = 0; index < 10; index++) {
			System.out.println("Employee "+ (index + 1) + " Bonus Amount: " + bonusAmount[index] + " Total Old Salary: " + oldSalary[index] + " New Salary: " + newSalary[index]);
		}
	}
}