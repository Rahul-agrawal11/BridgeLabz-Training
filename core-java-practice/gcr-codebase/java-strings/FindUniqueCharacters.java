import java.util.Scanner;

class FindUniqueCharacters {

    // Method to calculate string length without using length()
    public static int toCalculateLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    // Method to find unique characters
    public static char[] uniqueCharacters(String text) {
        int textLength = toCalculateLength(text);
        char[] temp = new char[textLength];
        int index = 0;

        for (int i = 0; i < textLength; i++) {
            boolean isUnique = true;

            // Check if character appeared before
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index++] = text.charAt(i);
            }
        }

        // Create exact-sized array
        char[] uniqueChar = new char[index];
        for (int i = 0; i < index; i++) {
            uniqueChar[i] = temp[i];
        }

        return uniqueChar;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.next();

        char[] uniqueChar = uniqueCharacters(text);

        System.out.print("Unique characters: ");
        for (char ch : uniqueChar) {
            System.out.print(ch + " ");
        }
    }
}
