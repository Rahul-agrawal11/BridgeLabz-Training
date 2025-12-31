class Course {

	// Instance Variables
	String courseName; 
	int duration;
	double fee;
	
	// Class Variable
	static String instituteName;
	
	// Constructor
	Course(String courseName, int duration, double fee) {
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		instituteName = "GLA University";
	}
	
	// Instance Method
	void displayCourseDetails() {
		System.out.println("Course Name: " + courseName);
		System.out.println("Course Duration: " + duration);
		System.out.println("Course Fee: " + fee);
	}
	
	// Class Method
	static void updateInstituteName() {
		instituteName = "GLA2 University";
		System.out.println("New Institite Name: " + instituteName);
	}
	
	public static void main(String[] args) {
		Course course1 = new Course("MCA", 2, 200000);
		Course course2 = new Course("BCA", 3, 150000);
		
		course1.displayCourseDetails();
		course2.displayCourseDetails();
		
		Course.updateInstituteName();
		
	}
}