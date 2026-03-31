/* 
 Maya’s BMI Fitness Tracker 🏃‍♀️
 Maya, a fitness coach, wants to record the BMI of her clients.
● Ask for height and weight.
● Use formula BMI = weight / (height * height)
● Print category using if-else: Underweight, Normal, Overweight.
Use clear variable names and comments to maintain code hygiene. 
 */

import java.util.Scanner;

class BMIFitnessTracker {
    public static void main(String[] args) {

        // Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Input weight in kilograms
        System.out.print("Enter weight in kg: ");
        double weightKg = input.nextDouble();

        // Input height in centimeters
        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();

        // Convert height from cm to meters
        double heightMeters = heightCm / 100;

        // Calculate BMI
        double bmi = weightKg / (heightMeters * heightMeters);

        // Display BMI value
        System.out.println("Your BMI is: " + bmi);

        // Determine BMI category
        if (bmi <= 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi < 25) {
            System.out.println("Category: Normal");
        } else if (bmi < 40) {
            System.out.println("Category: Overweight");
        } else {
            System.out.println("Category: Obese");
        }

        // Close the scanner
        input.close();
    }
}
