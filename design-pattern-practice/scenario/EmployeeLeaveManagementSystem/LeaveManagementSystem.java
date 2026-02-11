package scenario.EmployeeLeaveManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeaveManagementSystem {

	private HashMap<Integer, Employee> employees = new HashMap<>();
	private List<LeaveRequest> leaveRequests = new ArrayList<>();
		
	public boolean addEmployee(Employee emp) {
		employees.put(emp.getEmpId(), emp);
		return true;
	}
	
	public LeaveRequest applyLeave(int reqId, int empId, int days) throws InsufficientLeaveBalanceException {
		Employee emp = employees.get(empId);
		
		if (emp == null) {
			throw new InsufficientLeaveBalanceException("Employee not found with ID: " + empId);
		}
		
		if(days > emp.getLeaveBalance()) {
			throw new InsufficientLeaveBalanceException("Insufficient leave balance! Requested: " + days + ", Available: " + emp.getLeaveBalance());
		}
		
		LeaveRequest request = new LeaveRequest(reqId, empId, days);
		leaveRequests.add(request);
		return request;
	}
	
	public boolean approveLeave(int reqId) {
		for (LeaveRequest req : leaveRequests) {
			if (req.getReqId() == reqId && req.getStatus() == LeaveStatus.PENDING) {
				Employee emp = employees.get(req.getEmpId());
				emp.deductLeave(req.getDays());
				
				req.setStatus(LeaveStatus.APPROVED);
				return true;
			}
		}
		return false;
	}
	
	public boolean rejectLeave(int reqId) {
		for (LeaveRequest req : leaveRequests) {
			if (req.getReqId() == reqId && req.getStatus() == LeaveStatus.PENDING) {
				req.setStatus(LeaveStatus.REJECTED);
				return true;
			}
		}
		return false;
	}
	
	public void displayEmployees() {
		for (Employee e : employees.values()) {
			System.out.println(e);
		}
	}
	
	public void displayRequests() {
		for (LeaveRequest r : leaveRequests) {
			System.out.println(r);
		}
	}
}
