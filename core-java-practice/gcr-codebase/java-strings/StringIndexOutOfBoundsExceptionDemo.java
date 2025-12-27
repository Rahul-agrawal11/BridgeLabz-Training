import java.util.Scanner;

class StringIndexOutOfBoundsExceptionDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String s) {
        // Accessing index beyond string length
        System.out.println(s.charAt(s.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = input.next();

        // Generate exception (program crashes if not handled)
        try {
            generateException(s);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // Handle exception safely
        handleException(s);

        input.close();
    }
}
