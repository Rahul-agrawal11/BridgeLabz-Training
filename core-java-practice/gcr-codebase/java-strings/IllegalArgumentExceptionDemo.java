import java.util.Scanner;

class IllegalArgumentExceptionDemo {

    // Method to generate exception
    public static void generateException(String s) {
        // start index > end index
        System.out.println(s.substring(5, 2));
    }

    // Method to handle exception
    public static void handleException(String s) {
        try {
            System.out.println(s.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = input.next();

        // Generate exception
        try {
            generateException(s);
        } catch (RuntimeException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // Handle exception
        handleException(s);

        input.close();
    }
}
