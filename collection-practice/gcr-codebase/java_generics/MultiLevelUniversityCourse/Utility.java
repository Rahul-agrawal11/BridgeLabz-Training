package java_generics.MultiLevelUniversityCourse;

import java.util.List;

public class Utility {
	public static void displayCourses(List<? extends CourseType> courses) {

        for (CourseType course : courses) {
        	System.out.println("----------------------------");
        	course.getDetails();
            System.out.println("----------------------------");
        }
    }
}
