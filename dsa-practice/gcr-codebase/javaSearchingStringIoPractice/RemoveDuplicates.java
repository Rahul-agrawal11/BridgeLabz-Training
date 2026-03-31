package javaSearchingStringIoPractice;

import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {

    // Method to remove duplicates while maintaining order
    public static String removeDuplicates(String text) {

        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter text: ");
        String text = input.nextLine().toLowerCase();

        String withoutDup = removeDuplicates(text);

        System.out.println("String without duplicates: " + withoutDup);

        input.close();
    }
}
