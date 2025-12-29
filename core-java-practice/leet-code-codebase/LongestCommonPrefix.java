// 14. Longest Common Prefix

import java.util.Scanner;

class LongestCommonPrefix {

    // Method to find longest common prefix
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int i = 1;

        while (i < strs.length) {
            // Reduce prefix until it matches the start of strs[i]
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
            i++;
        }

        return prefix;
    }

    // Main method for user input
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = input.nextInt();
        input.nextLine(); // consume newline

        String[] strs = new String[n];

        System.out.println("Enter strings:");
        int i = 0;
        while (i < n) {
            strs[i] = input.nextLine();
            i++;
        }

        String result = longestCommonPrefix(strs);

        System.out.println("Longest Common Prefix: " + result);

        input.close();
    }
}
