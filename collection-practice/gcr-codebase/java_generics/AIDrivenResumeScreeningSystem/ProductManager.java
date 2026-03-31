package java_generics.AIDrivenResumeScreeningSystem;

public class ProductManager extends JobRole {
	
	ProductManager(String name, int experience) {
		super(name, experience);
	}
	
	@Override
	public String getRole() {
		return "Product Manager";
	}
	
	public void getDetails() {
		System.out.println("\n--- Product Manager Resumes ---");
		System.out.println("Role: " + getRole());
		System.out.println("Name: " + getName());
		System.out.println("Experience: " + getExperience());
	}
}
