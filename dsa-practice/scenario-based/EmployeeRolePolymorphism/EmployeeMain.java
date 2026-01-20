package scenario.EmployeeRolePolymorphism;

// Main class to test employee polymorphism
public class EmployeeMain {

    // Program execution starts here
    public static void main(String[] args) {

        // Create manager object
        Employee manager = new Manager("Alice", 80000);
        manager.dispalyDetails();
//        System.out.printf("%.2f%n", manager.getBonus());

        // Create developer with higher salary
        Employee developer1 = new Developer("Rahul", 60000);
        developer1.dispalyDetails();

        // Create developer with lower salary
        Employee developer2 = new Developer("Roop", 40000);
        developer2.dispalyDetails();
    }
}