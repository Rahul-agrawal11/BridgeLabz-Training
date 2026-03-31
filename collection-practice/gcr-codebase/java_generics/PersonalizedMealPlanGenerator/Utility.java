package java_generics.PersonalizedMealPlanGenerator;

public class Utility {

    // Generic method to validate and generate meal plans
    public static <T extends MealPlan> Meal<T> generateMeal(T mealPlan) {

        System.out.println("Valid meal plan selected");
        return new Meal<>(mealPlan);
    }
}
