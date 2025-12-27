import java.util.Scanner;

public class SubstringOccurrences {

    // static method with return value
    static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); // move past the current match
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String text = input.nextLine();

        System.out.print("Enter the substring: ");
        String sub = input.nextLine();

        int occurrences = countOccurrences(text, sub);

        System.out.println("Substring occurs " + occurrences + " times.");
    }
}
