import java.util.Scanner;

class NumberFormatExceptionDemo {

    public static void generateException(String s) {
        System.out.println(Integer.parseInt(s));
    }

    public static void handleException(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = input.next();
        
        try {
            generateException(s);
        } catch (NumberFormatException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // handled safely
        handleException(s);
    }
}