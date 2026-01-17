package javaSearchingStringIoPractice;

import java.util.Arrays;

public class SearchOperations {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {

        int n = nums.length;

        // Mark numbers as visited using index-based marking
        for (int i = 0; i < n; i++) {

            int value = Math.abs(nums[i]);

            // Mark index corresponding to value as negative (visited)
            if (value >= 1 && value <= n) {
                if (nums[value - 1] > 0) {
                    nums[value - 1] = -nums[value - 1];
                }
            }
        }

        // Find the first index with positive value
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // Missing positive number
            }
        }

        // If all numbers from 1 to n are present
        return n + 1;
    }

    // Method to find index of target element using Binary Search
    public static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Standard binary search loop
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Copy array because first missing positive modifies it
        int[] copyForMissing = Arrays.copyOf(nums, nums.length);

        // Find first missing positive integer
        int missing = findFirstMissingPositive(copyForMissing);

        // Sort array for binary search
        Arrays.sort(nums);

        // Find index of target using binary search
        int index = binarySearch(nums, target);

        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("First Missing Positive Integer: " + missing);
        System.out.println("Index of Target (" + target + "): " + index);
    }
}
