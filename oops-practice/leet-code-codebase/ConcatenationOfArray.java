/* 1929 Leetcode problem*/
import java.util.Scanner;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2*n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }
        return result;
    }
}

public class ConcatenationOfArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of array: ");
		int n = input.nextInt();
		
		int[] nums = new int[n];
		System.out.println("Enter array elements: ");
		for (int i = 0; i < n; i++) {
			nums[i] = input.nextInt();
		}
		
		Solution sn = new Solution();
		int[] result = sn.getConcatenation(nums);
		
		for (int num : result) {
			System.out.print(num + " ");
		}
	}
}