import java.util.Scanner;

class StringCharacters {

    // Method to create char array using charAt()
    public static char[] charArrayUsingCharAt(String s) {
        char[] charArray = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        return charArray;
    }

    // Comparison method
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        // Length check 
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = input.next();

        char[] charAtResult = charArrayUsingCharAt(s);
        char[] toCharArrayResult = s.toCharArray();

        boolean result = compareCharArrays(charAtResult, toCharArrayResult);

        if (result) {
            System.out.println("Both arrays have same characters.");
        } else {
            System.out.println("Both arrays do not have same characters.");
        }

        input.close();
    }
}
