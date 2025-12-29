// 11. Container With Most Water

import java.util.Scanner;

class ContainerWithMostWater {

    // Method to find maximum area
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            if (area > maxArea) {
                maxArea = area;
            }

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // Main method for user input
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] height = new int[n];

        System.out.println("Enter heights:");
        int i = 0;
        while (i < n) {
            height[i] = input.nextInt();
            i++;
        }

        int result = maxArea(height);

        System.out.println("Maximum water container area: " + result);

        input.close();
    }
}
