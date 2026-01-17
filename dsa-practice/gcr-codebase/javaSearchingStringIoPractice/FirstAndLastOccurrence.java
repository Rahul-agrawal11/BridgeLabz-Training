package javaSearchingStringIoPractice;

import java.util.Arrays;

public class FirstAndLastOccurrence {

    // Method to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1; // Stores index of first occurrence

        // Binary search loop
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // If target is found, store index and search left side
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            }
            // If target is smaller, move to left half
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            // If target is larger, move to right half
            else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Method to find the last occurrence of the target element
    public static int findLastOccurrence(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1; // Stores index of last occurrence

        // Binary search loop
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // If target is found, store index and search right side
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            }
            // If target is smaller, move to left half
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            // If target is larger, move to right half
            else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Sorted array with duplicate elements
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirstOccurrence(nums, target);
        int last = findLastOccurrence(nums, target);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("First Occurrence Index: " + first);
        System.out.println("Last Occurrence Index: " + last);
    }
}
