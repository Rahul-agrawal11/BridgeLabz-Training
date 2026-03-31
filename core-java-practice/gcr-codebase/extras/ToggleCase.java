import java.util.Scanner;

public class ToggleCase {

    // static method with return value
    static String toggleCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                result = result + Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                result = result + Character.toUpperCase(ch);
            } else {
                result = result + ch; // non-alphabetic characters remain same
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String toggled = toggleCase(text);

        System.out.println("Toggled Case String: " + toggled);
    }
}
