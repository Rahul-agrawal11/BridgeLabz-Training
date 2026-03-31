import java.util.Scanner;

class ArrayIndexOutOfBoundsExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        System.out.println(names[names.length]); // invalid index
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter length of array:");
        int arrayLength = input.nextInt();

        String[] names = new String[arrayLength];
        System.out.println("Enter names:");
        for (int i = 0; i < arrayLength; i++) {
            names[i] = input.next();
        }

        // Generate exception
        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // Handle exception
        handleException(names);

        input.close();
    }
}