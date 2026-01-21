package java_generics.AIDrivenResumeScreeningSystem;

public class SoftwareEngineer extends JobRole{

	SoftwareEngineer(String name, int experience) {
		super(name, experience);
	}
	
	@Override
	public String getRole() {
		return "SoftWare Engineer";
	}
	
	public void getDetails() {
		System.out.println("\n--- Software Engineer Resumes ---");
		System.out.println("Role: " + getRole());
		System.out.println("Name: " + getName());
		System.out.println("Experience: " + getExperience());
	}
}
