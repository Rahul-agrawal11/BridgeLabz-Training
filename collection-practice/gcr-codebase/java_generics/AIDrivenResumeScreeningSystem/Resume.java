package java_generics.AIDrivenResumeScreeningSystem;

import java.util.ArrayList;
import java.util.List;

public class Resume<T extends JobRole> {
	
	private List<T> resumes = new ArrayList<>();
	
	public boolean addResume(T resume) {
		return resumes.add(resume);
	}
	
	public List<T> getResumes() {
		return resumes;
	}
}
