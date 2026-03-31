class Circle {

	// Attribute
    double radius;

	// Default Constructor
    Circle() {
        this(1.0); // constructor chaining
    }

	// Parameterized Constructor
    Circle(double radius) {
        this.radius = radius;
    }

	// Display Radius
    void displayRadius() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
		
		// Default Constructor
        Circle c1 = new Circle();
        System.out.println("Default Circle:");
        c1.displayRadius();

		// Parameterized Constructor
        Circle c2 = new Circle(5.5);
        System.out.println("Parameterized Circle:");
        c2.displayRadius();
    }
}
