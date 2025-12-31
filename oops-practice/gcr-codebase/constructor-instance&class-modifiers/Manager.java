class Employee {

    // Public member
    public int employeeID;

    // Protected member
    protected String department;

    // Private member
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public getter for salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify salary
    public void updateSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }
}

class Manager extends Employee {

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);     // public
        System.out.println("Department: " + department);       // protected
        System.out.println("Salary: " + getSalary());           // private via getter
    }

    public static void main(String[] args) {

        Manager manager =
                new Manager(101, "IT", 75000.0);

        manager.displayEmployeeDetails();

        // Modify salary using public method
        manager.updateSalary(85000.0);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}
