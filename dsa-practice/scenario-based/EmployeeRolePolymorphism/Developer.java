package scenario.EmployeeRolePolymorphism;

// Developer employee implementation
public class Developer extends Employee {

    // Constructor to initialize developer details
    public Developer(String name, int salary) {
        super(name, salary);
    }

    // Calculates bonus for developer
    @Override
    public double getBonus() {
        if (super.getSalary() > 50000) {
            return (super.getSalary() / 100.0) * 5;
        }
        return 0;
    }

    // Displays developer details
    public void dispalyDetails() {
        super.dispalyDetails();
        System.out.println("Role: Developer");
        System.out.println("Bonus: " + getBonus());
        System.out.println("=================================================");
    }
}