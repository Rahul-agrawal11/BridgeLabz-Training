package leetcode;

//First Unique Character in a String (LeetCode #387)

import java.util.HashMap;

public class FirstUniqueChar {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (char ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}

