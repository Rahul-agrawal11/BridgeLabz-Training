class Patient {
	
	// Static variable shared across all products
	private static String hospitalName = "City Hospital";
	private static int totalPatients = 0;
	
	
	// Final variable to ensure Patient Id number cannot be changed once assigned
	private final String patientId;
	private String name;
	private int age;
	private String aliment;
	
	// Constructor using 'this' to avoid ambiguity
	Patient(String patientId, String name, int age, String aliment) {
		this.patientId = patientId;             // Final variable assigned only once
		this.name = name;
		this.age = age;             
		this.aliment = aliment;     
		totalPatients++;
	}
	
	// Static method to display total patients
	public static void displayTotalPatients() {
		System.out.println("Total Patients: " + totalPatients);
	}
	
	// Static method to display hospital name
	public static void displayHospitalName() {
		System.out.println("Hospital Name: " + hospitalName);
	}
	
	// Method to display patient details
	public void displayPatientDetails() {
		if(this instanceof Patient) {
			Patient.displayHospitalName();
			System.out.println("Patient ID: " + patientId);
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
		} else {
			System.out.println("Invalid Patient instance");
		}
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// Main method for testing
	public static void main(String[] args) {
		
		// Create two patient details
		Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");
		Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");
		
		// Display total patients
		Patient.displayTotalPatients();
		
		// Display employee details
		patient1.displayPatientDetails();
		patient2.displayPatientDetails();
	}	
}