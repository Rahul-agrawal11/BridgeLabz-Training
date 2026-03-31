package scenario.EmployeeLeaveManagementSystem;

public class LeaveRequest {
	private int reqId;
	private int empId;
	private int days;
	private LeaveStatus status;
	
	public LeaveRequest(int reqId, int empId, int days) {
		this.reqId = reqId;
		this.empId = empId;
		this.days = days;
		this.status = LeaveStatus.PENDING;
	}
	public int getReqId() {
		return reqId;
	}
	public int getEmpId() {
		return empId;
	}
	public int getDays() {
		return days;
	}
	public LeaveStatus getStatus() {
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Request Id: " + reqId + " Employee Id: " + empId + " Days: " + days + " Status: " + status;
	}
	
}
