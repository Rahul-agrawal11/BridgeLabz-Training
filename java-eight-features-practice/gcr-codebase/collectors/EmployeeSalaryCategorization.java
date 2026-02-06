package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	String name;
	String department;
	double salary;
	public Employee(String name, String department, double salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalaryCategorization {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Rahul", "IT", 60000),
				new Employee("Deepa", "CSE", 50000),
				new Employee("Mahi", "CA", 40000),
				new Employee("Sagar", "IT", 30000),
				new Employee("Kavi", "CA", 20000));
		
		Map<String, Double> avgSalaryByDept = employees.stream() .collect(Collectors.groupingBy(Employee::getDepartment, 
				Collectors.averagingDouble(Employee::getSalary)));
		
		System.out.println(avgSalaryByDept);
	}

}
