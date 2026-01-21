package java_generics.MultiLevelUniversityCourse;

public class AssignmentCourse extends CourseType{
	
	public AssignmentCourse(String courseName, int courseDuration) {
		super(courseName, courseDuration);
	}
	
	public String getCourseType() {
		return "Assignment-based";
	}
	
	@Override
	public void getDetails() {
		System.out.println("\n--- Assignment-Based Courses ---");
		System.out.println("Course Type: " + getCourseType());
		System.out.println("Course Name: " + super.getCourseName());
		System.out.println("Course Name: " + super.getCourseDuration());
	}
}
