
import java.util.Scanner;

class StringComparison {

    public static boolean comparisonUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first string: ");
        String s1 = input.next();
        System.out.println("Enter second string: ");
        String s2 = input.next();

        boolean charAtResult = comparisonUsingCharAt(s1, s2);

        boolean equalsResult = s1.equals(s2);

        System.out.println("Result using charAt(): " + charAtResult);
        System.out.println("Result using equals(): " + equalsResult);

        if (charAtResult == equalsResult) {
            System.out.println("Both comparison results are SAME.");
        } else {
            System.out.println("Both comparison results are DIFFERENT.");
        }

        input.close();
    }
}
