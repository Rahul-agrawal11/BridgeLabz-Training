// Superclass
class Course {
	String courseName;
	int duration;
	
	// Constructor	
	Course(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}
	
	// Method to display course details
	String getCourseDetails() {
		return "Course Name: " + courseName + "\nCourse Duration: " + duration;
	}
}

// Subclass
class OnlineCourse extends Course {
	String platform;
	boolean isRecorded;
	// Constructor
	OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}
	
	// Method to display online course details
	String getOnlineCourseDetails() {
		return getCourseDetails() + "\nPlatform: " + platform + "\nisRecorded: " + isRecorded;
	}
}

// Subclass of OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
	double fee;
	double discount;
	
    // Constructor
	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
		super(courseName, duration, platform, isRecorded);
		this.fee = fee;
		this.discount = discount;
	}
	
	// Method to calculate final fee
	double calculateFinalFee() {
		return fee - ((fee / 100) * discount);
	}
	
	// Method to display full paid course details
	String getPaidCourseDetails() {
        return getOnlineCourseDetails() +
               "\nFee: ₹" + fee +
               "\nDiscount: " + discount + "%" +
               "\nFinal Fee: ₹" + calculateFinalFee();
    }
}

// Main class
public class EducationalCourse {
	public static void main(String[] args) {
		
		PaidOnlineCourse course = new PaidOnlineCourse("Java Full Stack", 5, "BridgeLabz", true, 75500, 10);
		
		System.out.println(course.getPaidCourseDetails());
	}
}