package java_generics.MultiLevelUniversityCourse;

import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {
	
	private List<T> courses = new ArrayList<>();
	
	public boolean addCourse(T course) {
		return courses.add(course);
	}
	
	public List<T> getCourses() {
		return courses;
	}
}
