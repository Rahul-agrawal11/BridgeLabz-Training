package java_generics.PersonalizedMealPlanGenerator;

public class VeganMeal implements MealPlan{
	
	public void showDetails() {
		System.out.println("A nutrient-dense, plant-based dish made entirely without "
				+ "animal products—such as meat, dairy, eggs, or honey—relying instead on whole grains, vegetables, legumes, nuts, and fruits.");
	}
}
