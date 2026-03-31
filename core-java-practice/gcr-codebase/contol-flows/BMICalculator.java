// Create a program to find the BMI of a person

import java.util.Scanner;

class BMICalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weight = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();

        double heightInMtr = height * 0.01;
        double BMI = weight / (heightInMtr * heightInMtr);

        if (BMI < 18.5) {
            System.out.println("Underweight");
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.println("Normal weight");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        input.close();
    }
}
