package java_generics.MultiLevelUniversityCourse;

public abstract class CourseType {
	
	private String courseName;
	private int courseDuration;
	
	protected CourseType(String courseName, int courseDuration) {
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	public abstract String getCourseType();
	
	public abstract void getDetails();
}
