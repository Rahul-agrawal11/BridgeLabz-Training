// 3. Longest Substring Without Repeating Characters 

import java.util.Scanner;

class LongestSubstringWithoutRepeatingCharacters {

    // Method to find length
    public static int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256]; // ASCII character frequency
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            // If character already exists, shrink window
            while (freq[ch] > 0) {
                freq[s.charAt(left)]--;
                left++;
            }

            // Add current character
            freq[ch]++;
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    // Main method for user input
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int result = lengthOfLongestSubstring(text);

        System.out.println("Length of longest substring without repeating characters: " + result);

        input.close();
    }
}
