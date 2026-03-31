package collections.map;

import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {

    public static Map<String, List<Employee>> groupEmployees(List<Employee> employees) {

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee emp : employees) {

            // If department not present, create new list
            map.putIfAbsent(emp.department, new ArrayList<>());

            // Add employee to department list
            map.get(emp.department).add(emp);
        }

        return map;
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        System.out.println(groupEmployees(employees));
    }
}

