package csvHandling;

import java.io.*;
import java.util.ArrayList;

class Student {
	String id;
	String name;
	int age;
	int marks;
	public Student(String id, String name, int age, int marks) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
}

public class ConvertCSV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students.csv";
		ArrayList<Student> students = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				students.add(new Student(columns[0] , columns[1], Integer.valueOf(columns[2]), Integer.valueOf(columns[3])));
			}
			
			System.out.println("ID\tName\tAge\tMarks");
			for(Student s : students) {
				System.out.println(s.id + "\t" + s.name + "\t" + s.age + "\t" + s.marks);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
