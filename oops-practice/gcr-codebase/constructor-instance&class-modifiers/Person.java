class Person {

	// Attribute
    String name;
    int age;
	
	// Parameterized Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	// Copy Constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }
	
	// Display Person Details
    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
		
		// Parameterized Constructor
        Person p1 = new Person("Rahul", 21);
        System.out.println("Original Person:");
        p1.displayPerson();

		// Copy Constructor
        Person p2 = new Person(p1);
        System.out.println("\nCopied Person:");
        p2.displayPerson();
    }
}
