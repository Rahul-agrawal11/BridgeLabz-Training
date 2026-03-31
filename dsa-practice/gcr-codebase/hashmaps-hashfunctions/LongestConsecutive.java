package HashMapsHashFunctions;

import java.util.*;

public class LongestConsecutive {

    public static int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
    
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        int length = LongestConsecutive.longestConsecutive(arr);
        System.out.println("Longest Consecutive Sequence Length: " + length);
    }
}
