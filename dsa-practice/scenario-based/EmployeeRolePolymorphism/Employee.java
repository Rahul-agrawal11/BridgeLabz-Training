package scenario.EmployeeRolePolymorphism;

// Abstract class for all employees
public abstract class Employee {

    // Stores employee name
    private final String name;

    // Stores employee salary
    private final int salary;

    // Constructor to initialize employee details
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Returns employee name
    public String getName() {
        return name;
    }

    // Returns employee salary
    public int getSalary() {
        return salary;
    }

    // Calculates bonus (implemented by subclasses)
    public abstract double getBonus();

    // Displays employee details
    public void dispalyDetails() {
        System.out.println("================Employee Details===================");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}