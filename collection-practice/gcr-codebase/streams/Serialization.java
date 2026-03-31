package streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class must implement Serializable
class Employee implements Serializable {

    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private int id;
    private String name;
    private String department;
    private int salary;

    // Constructor
    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Override toString() for easy printing of object data
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class Serialization {

    public static void main(String[] args) {

        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Rahul", "Computer Application", 30000));
        employees.add(new Employee(102, "Amit", "IT", 40000));
        employees.add(new Employee(103, "Neha", "HR", 35000));

        String fileName = "employees.ser";

        // ================= SERIALIZATION =================
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            // Write the list of employees into file
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");

        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        // ================= DESERIALIZATION =================
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            // Read the list of employees from file
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();

            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
    }
}