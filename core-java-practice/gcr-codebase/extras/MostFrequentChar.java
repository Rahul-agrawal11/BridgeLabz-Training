import java.util.Scanner;

public class MostFrequentChar {

    // static method with return value
    static char mostFrequentChar(String text) {
        int maxCount = 0;
        char frequent = ' ';

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                frequent = ch;
            }
        }

        return frequent;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char frequentChar = mostFrequentChar(text);

        System.out.println("Most Frequent Character: '" + frequentChar + "'");
    }
}