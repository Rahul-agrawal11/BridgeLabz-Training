import java.util.Scanner;

public class CharacterType {

    // Method 1: Check whether character is Vowel, Consonant, or Not a Letter
    static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method 2: Find character type for each character and store in 2D array
    static String[][] findCharacterTypes(String str) {

        String[][] result = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }

    // Method 3: Display 2D Array in Tabular Format
    static void displayTable(String[][] data) {

        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = input.nextLine();

        String[][] output = findCharacterTypes(string);
        displayTable(output);

        input.close();
    }
}
