package java_generics.AIDrivenResumeScreeningSystem;

import java.util.List;

public class Utility {

	public static void displayDetails(List<? extends JobRole> roles) {
		
		for (JobRole role : roles) {
			role.getDetails();
            System.out.println("--------------------");
		}
	}
}
