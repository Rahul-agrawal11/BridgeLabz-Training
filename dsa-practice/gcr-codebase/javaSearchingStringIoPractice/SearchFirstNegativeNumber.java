package javaSearchingStringIoPractice;

import java.util.Scanner;

// Method to search first negative number by using Linear Search
public class SearchFirstNegativeNumber {
	
	public static int findFirstNegativeNum(int[] nums) {
		int count = 0;
		for (int num : nums) {
			count++;
			// If found negative number, return the index of number
			if (num < 0) {
				return count;
			}
		}
		// If there is no negative number returns -1
		return -1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter length of nums array: ");
		int length = input.nextInt();
		
		int nums[] = new int[length];
		
		System.out.println("Enter numbers for array: ");
		for (int index = 0; index < length; index++) {
			nums[index] = input.nextInt();
		}
		input.close();
		
		// Variable to store result coming from the method call
		int negativeNumIndex = SearchFirstNegativeNumber.findFirstNegativeNum(nums);
		
		if (negativeNumIndex == -1) {
			System.out.println("There is no negative number in the array.");
		} else {
			System.out.println("First Negative Number Index is: " + negativeNumIndex);
		}
	}

}
