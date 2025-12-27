import java.util.Scanner;

public class ReverseString {

    // static method with return value
    static String reverseString(String str) {
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String result = reverseString(text);

        System.out.println("Reversed String: " + result);
    }
}
