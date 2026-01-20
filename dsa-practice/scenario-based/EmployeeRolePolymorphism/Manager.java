package scenario.EmployeeRolePolymorphism;

// Manager employee implementation
public class Manager extends Employee {

    // Constructor to initialize manager details
    public Manager(String name, int salary) {
        super(name, salary);
    }

    // Calculates bonus for manager
    @Override
    public double getBonus() {
        return (super.getSalary() / 10.0);
    }

    // Displays manager details
    public void dispalyDetails() {
        super.dispalyDetails();
        System.out.println("Role: Manager");
        System.out.println("Bonus: " + getBonus());
        System.out.println("=================================================");
    }
}
