import java.util.Scanner;

class AreaOfCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        double radius = input.nextDouble();

        double area = Math.PI * radius * radius;

        System.out.println("Area of the circle: " + area);
    }
}
