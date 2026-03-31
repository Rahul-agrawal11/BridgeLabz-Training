public class Circle {

    // Attribute
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display results
    void displayCircleDetails() {
        System.out.printf("Area of circle: %.4f%n", calculateArea());
        System.out.printf("Circumference of circle: %.4f%n", calculateCircumference());
    }

    public static void main(String[] args) {

        // Creating Circle object (radius chosen to match given output)
        Circle circle = new Circle(2.5);

        // Display area and circumference
        circle.displayCircleDetails();
    }
}