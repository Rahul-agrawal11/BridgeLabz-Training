package javaSearchingStringIoPractice;

import java.util.Arrays;

public class SearchIn2DMatrix {

    // Method to search a target value in a sorted 2D matrix using Binary Search
    public static boolean searchNumber(int[][] nums, int rows, int columns, int target) {

        // Treat the 2D matrix as a flattened 1D array
        int left = 0;
        int right = rows * columns - 1;

        // Standard binary search loop
        while (left <= right) {

            // Find middle index safely to avoid overflow
            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D row and column
            int row = mid / columns;
            int col = mid % columns;

            // If target is found, return true
            if (nums[row][col] == target) {
                return true;
            }
            // If target is smaller, search left half
            else if (target < nums[row][col]) {
                right = mid - 1;
            }
            // If target is larger, search right half
            else {
                left = mid + 1;
            }
        }

        // Target not found in the matrix
        return false;
    }

    public static void main(String[] args) {

        // Given sorted 2D matrix
        int[][] nums = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        // Number of rows and columns
        int rows = nums.length;
        int columns = nums[0].length;

        int target = 16;
        // Search for target value
        boolean isPresent = searchNumber(nums, rows, columns, target);
        System.out.println("Array: " + Arrays.deepToString(nums));
        System.out.println("Target: " + target);
        System.out.println("Is Present: " + isPresent);
    }
}