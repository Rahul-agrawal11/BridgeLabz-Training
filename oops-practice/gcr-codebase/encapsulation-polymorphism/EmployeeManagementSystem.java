abstract class Employee {
    private int empId;
    private String name;
    private double baseSalary;

    // Constructor
    Employee(int empId, String name, double baseSalary) {
        this.empId = empId;
        this.name = name;
        setBaseSalary(baseSalary);
    }

    // Encapsulation: getters & setters
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee Id   : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Base Salary   : " + baseSalary);
    }
}

// Interface
interface Department {
    String assignDepartment();
    String getDepartmentDetails();
}

// Full-time employee
class FullTimeEmployee extends Employee implements Department {

    private String department;

    public FullTimeEmployee(int empId, String name, double baseSalary, String department) {
        super(empId, name, baseSalary);
        this.department = department;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // fixed monthly salary
    }

    @Override
    public String assignDepartment() {
        return department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Part-time employee
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int empId, String name, int hoursWorked, double hourlyRate) {
        super(empId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Employee[] employees = new Employee[2];

        employees[0] = new FullTimeEmployee(101, "Rahul", 50000, "IT");
        employees[1] = new PartTimeEmployee(102, "Amit", 80, 300);

        // Polymorphism: Employee reference
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Final Salary  : " + emp.calculateSalary());

            if (emp instanceof Department) {
                Department dept = (Department) emp;
                System.out.println(dept.getDepartmentDetails());
            }

            System.out.println("---------------------------");
        }
    }
}
