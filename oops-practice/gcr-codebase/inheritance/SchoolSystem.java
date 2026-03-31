// Super Class
class Person {
	String name;
	int age;
	
	void displayRole() {
		System.out.println("Person");
	}
}

// Subclass of Person
class Teacher extends Person {
	String subject;
	
	@Override
	void displayRole() {
		System.out.println("Role: Teacher");
	}
}

// Subclass of Person
class Student extends Person {
	char grade;
	
	@Override
	void displayRole() {
		System.out.println("Role: Student");
	}
}

// Subclass of Person
class Staff extends Person {
	
	@Override
	void displayRole() {
		System.out.println("Role: School Staff");
	}
}

// Main Class
class SchoolSystem {
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		Student student = new Student();
		Staff staff = new Staff();
		
		teacher.displayRole();
		student.displayRole();
		staff.displayRole();
	}
}
