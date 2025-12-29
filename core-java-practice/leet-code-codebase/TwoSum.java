// 1. Two Sum 

import java.util.Scanner;

class TwoSum {

    // Two Sum logic using while loops
    public static int[] twoSum(int[] nums, int target) {

        int i = 0;

        while (i < nums.length) {
            int j = i + 1;

            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
                j++;
            }
            i++;
        }

        return new int[] { -1, -1 };
    }

    // Main method for user input
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = input.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        int i = 0;
        while (i < n) {
            nums[i] = input.nextInt();
            i++;
        }

        System.out.print("Enter target sum: ");
        int target = input.nextInt();

        int[] result = twoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two elements found with given target.");
        }

        input.close();
    }
}
