package java_generics.PersonalizedMealPlanGenerator;

import java.util.Scanner;

public class MealPlanMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("====== Personalized Meal Plan Generator ======");
        System.out.println("1. Vegetarian Meal");
        System.out.println("2. Vegan Meal");
        System.out.println("3. Keto Meal");
        System.out.println("4. High Protein Meal");
        System.out.print("Choose your meal plan: ");

        choice = sc.nextInt();

        Meal<? extends MealPlan> meal = null;

        switch (choice) {

            case 1:
                meal = Utility.generateMeal(new VegetarianMeal());
                break;

            case 2:
                meal = Utility.generateMeal(new VeganMeal());
                break;

            case 3:
                meal = Utility.generateMeal(new KetoMeal());
                break;

            case 4:
                meal = Utility.generateMeal(new HighProteinMeal());
                break;

            default:
                System.out.println("Invalid choice! Please select a valid option.");
                sc.close();
                return;
        }

        System.out.println("\n--- Your Personalized Meal Plan ---");
        meal.getDetails();

        sc.close();
    }
}
