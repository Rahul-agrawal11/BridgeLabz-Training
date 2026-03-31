import java.util.Scanner;

public class RemoveDuplicates {

    // static method with return value
    static String removeDuplicates(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (result.indexOf(ch) == -1) { // character not in result
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String modifiedText = removeDuplicates(text);

        System.out.println("String after removing duplicates: " + modifiedText);
    }
}
