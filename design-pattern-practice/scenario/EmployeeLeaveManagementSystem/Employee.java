package scenario.EmployeeLeaveManagementSystem;

public class Employee {
	
	private int empId;
	private String empName;
	private int leaveBalance;
	
	public Employee(int empId, String empName, int leaveBalance) {
		this.empId = empId;
		this.empName = empName;
		this.leaveBalance = leaveBalance;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public int getLeaveBalance() {
		return leaveBalance;
	}
	
	public void deductLeave(int days) {
		this.leaveBalance -= days;
	}
	
	@Override
	public String toString() {
		return "Employee ID: " + empId + " Employee Name: " + empName + " Leave Balance: " + leaveBalance;
	}
}
