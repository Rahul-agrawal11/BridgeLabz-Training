package java_generics.PersonalizedMealPlanGenerator;

public class Meal<T extends MealPlan> {
	
	T mealplan;
	
	public Meal(T mealplan) {
		this.mealplan = mealplan;
	}
	
	public void getDetails() {
		mealplan.showDetails();
	}
}
