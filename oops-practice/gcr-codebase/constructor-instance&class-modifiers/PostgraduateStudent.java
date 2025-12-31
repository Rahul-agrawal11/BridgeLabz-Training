class Student {
	
	// Attributes
	public int rollNumber;
	protected String name;
	private double cgpa;
	
	// Constructor
	Student(int rollNumber, String name, double cgpa) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	// Public getter for CGPA
	public double getCGPA() {
		return cgpa;
	}
	
	// Public setter for CGPA
	public void setCGPA(double cgpa) {
		if (cgpa >= 0.0 && cgpa <= 10.0) {
			this.cgpa = cgpa;
		} else {
            System.out.println("Invalid CGPA value");
        }
	}
}

class PostgraduateStudent extends Student {
	
	PostgraduateStudent(int rollNumber, String name, double cgpa) {
		super(rollNumber, name, cgpa);
	}
	
	void displayDetails() {
        System.out.println("Roll Number: " + rollNumber); // public
        System.out.println("Name: " + name);               // protected
        System.out.println("CGPA: " + getCGPA());           // private via getter
    }
	
	public static void main(String[] args) {

        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Rahul", 8.5);

        pgStudent.displayDetails();
		
		// Modifying CGPA using public method
		pgStudent.setCGPA(9.2);
        System.out.println("Updated CGPA: " + pgStudent.getCGPA());
	}
}
