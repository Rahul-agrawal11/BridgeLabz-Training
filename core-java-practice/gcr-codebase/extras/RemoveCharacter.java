import java.util.Scanner;

public class RemoveCharacter {

    // static method with return value
    static String removeCharacter(String text, char chToRemove) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != chToRemove) {
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.print("Enter character to remove: ");
        char chToRemove = input.next().charAt(0);

        String modifiedText = removeCharacter(text, chToRemove);

        System.out.println("Modified String: " + modifiedText);
    }
}
