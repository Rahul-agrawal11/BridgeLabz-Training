import java.util.Scanner;

public class Handshakes {

    // Method to calculate maximum number of handshakes
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Method call
        int handshakes = calculateHandshakes(numberOfStudents);

        // Output
        System.out.println("The maximum number of possible handshakes is " + handshakes);

        input.close();
    }
}
