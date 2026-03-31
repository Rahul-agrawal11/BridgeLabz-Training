package java_generics.AIDrivenResumeScreeningSystem;

public class DataScientist extends JobRole{
	
	DataScientist(String name, int experience) {
		super(name, experience);
	}
	
	@Override
	public String getRole() {
		return "Data Scientist";
	}
	
	public void getDetails() {
		System.out.println("\n--- Data Scientist Resumes ---");
		System.out.println("Role: " + getRole());
		System.out.println("Name: " + getName());
		System.out.println("Experience: " + getExperience());
	}
}
