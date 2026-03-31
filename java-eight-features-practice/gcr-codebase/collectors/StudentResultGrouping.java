package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
	String name;
	char grade;
	public Student(String name, char grade) {
		this.name = name;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public char getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}

public class StudentResultGrouping {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Rahul", 'O'),
				new Student("Deepa", 'A'),
				new Student("Mahi", 'A'),
				new Student("Sumit", 'B'),
				new Student("Aditya", 'O'),
				new Student("Utkarsh", 'B'));
		
		Map<Character, List<Student>> grouped = students.stream().collect(Collectors.groupingBy(Student::getGrade));
		System.out.println(grouped);
		
	}

}
