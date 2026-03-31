package java_generics.MultiLevelUniversityCourse;

public class ExamCourse extends CourseType{
	
	public ExamCourse(String courseName, int courseDuration) {
		super(courseName, courseDuration);
	}
	
	public String getCourseType() {
		return "Exam-based";
	}
	
	@Override
	public void getDetails() {
		System.out.println("\n--- Exam-Based Courses ---");
		System.out.println("Course Type: " + getCourseType());
		System.out.println("Course Name: " + super.getCourseName());
		System.out.println("Course Name: " + super.getCourseDuration());
	}
}
