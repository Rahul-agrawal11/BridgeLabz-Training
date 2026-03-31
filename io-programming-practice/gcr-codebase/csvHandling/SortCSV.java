package csvHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee> {
	String id;
	String name;
	String department;
	int salary;
	
	public Employee(String id, String name, String department, int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee e) {
		return e.salary - this.salary; 
	}
}

public class SortCSV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\employee.csv";
		ArrayList<Employee> employee = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				employee.add(new Employee(data[0], data[1], data[2], Integer.parseInt(data[3])));
			}
			System.out.println("Added Successfully!");
			Collections.sort(employee);
			System.out.println("ID\tName\t\tDepartment\tSalary");
			int count = 0;
			for(Employee e :  employee) {
				if (count == 5) {
					break;
				}
				count++;
				System.out.println(e.id + "\t" +  e.name + "\t\t" + e.department + "\t\t" + e.salary);
			}
		} catch(Exception e) {
			
		}
	}

}
