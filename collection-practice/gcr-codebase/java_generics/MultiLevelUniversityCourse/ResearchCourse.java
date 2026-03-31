package java_generics.MultiLevelUniversityCourse;

public class ResearchCourse extends CourseType{
	
	public ResearchCourse(String courseName, int courseDuration) {
		super(courseName, courseDuration);
	}
	
	public String getCourseType() {
		return "Research-based";
	}
	
	@Override
	public void getDetails() {
		System.out.println("\n--- Research-Based Courses ---");
		System.out.println("Course Type: " + getCourseType());
		System.out.println("Course Name: " + super.getCourseName());
		System.out.println("Course Name: " + super.getCourseDuration());
	}
}
