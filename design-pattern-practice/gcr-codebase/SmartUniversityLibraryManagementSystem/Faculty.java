package SmartUniversityLibraryManagementSystem;

public class Faculty implements User {
	private String name;

	public Faculty(String name) {
		this.name = name;
	}
	
	@Override
	public void showRole() {
		System.out.println(name + " is a Faculty.");
	}
	
	@Override 
	public int getBorrowLimit() {
		return 20;
	}
	
	@Override
	public void update(String msg) {
		System.out.println(name + " notified: " + msg);
	}
}
