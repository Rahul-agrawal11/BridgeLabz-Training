package javaSearchingStringIoPractice;

public class FindPeakElement {
	
	public static int peakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		
		while (left != right) {
			mid = (left + right) / 2;
			
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return nums[mid];
			} else if ( nums[mid] < nums[mid - 1]) {
				right = mid - 1;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			}
		}
		return nums[mid];
	}
	
	public static void main(String[] args) {
		
		int nums[] = {10, 20, 15, 2, 23, 90, 80};
		
		int element = peakElement(nums);
		System.out.println("Peak Element: " + element);
	}
}
