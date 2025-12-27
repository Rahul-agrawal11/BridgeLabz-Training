import java.util.Scanner;

class LargestAndSecondLargest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int maxDigit = 10;
		int[] digits = new int[maxDigit];
		
		// Addind digits into array
		int index = 0;
		while (number > 0) {
			int reminder = number % 10;
			digits[index] = reminder;
			number /= 10;
			if (index < maxDigit) {
				index++;
			} else {
				break;
			}
		}
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		// Check for largest and second largest
		for (int num : digits) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num != largest) {
				secondLargest = num;
			}
		}
		System.out.println("Largest number: " + largest + " Second Largest: " + secondLargest);
	}
}