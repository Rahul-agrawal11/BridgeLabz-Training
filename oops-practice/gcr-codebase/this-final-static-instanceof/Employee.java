class Employee {
	
	// Static variable shared across all employees
	private static String companyName = "Tech Solutions Inc.";
	private static int totalEmployees = 0;
	
	// Final variable to ensure EmployeeId number cannot be changed once assigned
	private final int empId;
	private String name;
	private String designation;
	
	// Constructor using 'this' to avoid ambiguity
	Employee(String name, String designation, int empId) {
		this.name = name;
		this.designation = designation;
		this.empId = empId;       // Final variable assigned only once
		totalEmployees++;        // Increment total employees with each new employee
	}
	
	// Static method to get total employee 
	public static void displayTotalEmployees() {
		System.out.println("Total Employees: " + totalEmployees);
	}
	
	// Static method to get company name
	public static void displayCompanyName() {
		System.out.println("Comapany Name: " + companyName);
	}
	
	// Method to display employee details
	public void displayEmployeeDetails() {
		if(this instanceof Employee) {
			System.out.println("Employee ID: " + empId);
			System.out.println("Name: " + name);
			System.out.println("Designation: " + designation);
		} else {
			System.out.println("Invalid Employee instance");
		}
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	// Main method for testing
	public static void main(String[] args) {
		// Create two employee details
		Employee employee1 = new Employee("Thamarai", "Software Engineer", 101);
		Employee employee2 = new Employee("Rohan", "Project Manager", 102);
		
		// Display Library Name
		Employee.displayTotalEmployees();
		
		// Display employee details
		Employee.displayCompanyName();
		employee1.displayEmployeeDetails();
		Employee.displayCompanyName();
		employee2.displayEmployeeDetails();	
	}	
}