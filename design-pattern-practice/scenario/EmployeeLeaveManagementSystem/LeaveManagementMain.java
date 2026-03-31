package scenario.EmployeeLeaveManagementSystem;

public class LeaveManagementMain {

	public static void main(String[] args) {
		LeaveManagementSystem system = new LeaveManagementSystem();
		
		system.addEmployee(new Employee (101, "Rahul", 5));
		system.addEmployee(new Employee (102, "Vishnu", 3));
		
		try {
			system.applyLeave(1, 101, 4);
			system.applyLeave(2, 102, 4);
		} catch (InsufficientLeaveBalanceException e) {
			System.out.println(e.getMessage());
		}
		
		system.approveLeave(1);
	    system.rejectLeave(2);

	    System.out.println("\n--- Employees ---");
	    system.displayEmployees();

	    System.out.println("\n--- Leave Requests ---");
	    system.displayRequests();
	}
}
