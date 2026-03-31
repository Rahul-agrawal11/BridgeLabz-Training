package java_generics.AIDrivenResumeScreeningSystem;

public abstract class JobRole {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	private String name;
	private int experience;
	
	protected JobRole(String name, int experience) {
		this.name = name;
		this.experience = experience;
	}
	
	public abstract String getRole();
	
	public abstract void getDetails();
}
