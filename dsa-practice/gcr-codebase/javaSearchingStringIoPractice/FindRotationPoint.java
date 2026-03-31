package javaSearchingStringIoPractice;

public class FindRotationPoint {
	
	// Method to find minimum number and its index value
	public static int[] findMinWithIndex(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left != right) {
			
			int mid = (left + right) / 2;
			
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			}
		}
		return new int[] {nums[left], left};
	}
	
	public static void main(String[] args) {
		
		int[] nums = {4, 5, 6, 7, 1, 2, 3};

		int[] result = findMinWithIndex(nums);
        System.out.println("Smallest Num: " + result[0]);
        System.out.println("Its index: " + result[1]);
	}
}
