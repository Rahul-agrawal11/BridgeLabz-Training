import java.util.Scanner;

class StringLengthDemo {

    // Method to find string length without using length()
    public static int findLengthWithoutLength(String s) {
        int count = 0;

        while (true) {
            try {
                s.charAt(count); // access character at current index
                count++;         // increment count if no exception
            } catch (StringIndexOutOfBoundsException e) {
                break;           // stop when index is out of bounds
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = input.next();

        // Using user-defined method
        int lengthManual = findLengthWithoutLength(text);

        // Using built-in length() method
        int lengthBuiltIn = text.length();

        System.out.println("Length using charAt() method: " + lengthManual);
        System.out.println("Length using length() method: " + lengthBuiltIn);

        input.close();
    }
}