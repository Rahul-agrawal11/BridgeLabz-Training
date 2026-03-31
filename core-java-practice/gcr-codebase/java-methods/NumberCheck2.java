import java.util.Scanner;

public class NumberCheck2 {
	
	// Method to count digits
	public static int countDigits(int number) {
		int count = 0;
		while (number > 0) {
			number /= 10;
			count++;
		}
		return count;
	}
	
	// Method to store digits in array
	public static int[] digitArray(int number) {
		int count = countDigits(number);
		int[] digitArr = new int[count];
		int index = 0;
		
		while (number > 0) {
			int digit = number % 10;
			number /= 10;
			digitArr[index++] = digit;
		}
		return digitArr;
	}
	
	// Method to check duck number
	public static boolean checkDuckNumber(int number){
		int[] digitArr = digitArray(number);
		for (int digit : digitArr) {
			if (digit != 0) {
				return true;
			}
		}
		return false;
	}
	
	// Method to check armstrong number
	public static boolean checkArmstrongNumber(int number) {
		int count = countDigits(number);
		int[] digitArr = digitArray(number);
		
		int sum = 0;
		
		for (int i = 0; i < count; i++) {
			sum += Math.pow(digitArr[i], count);
		}
		
		if (number != sum) {
			return false;
		}
		return true;
	}
	
	// Method to find largest and second largest digits
	public static int[] largestAndSecondLargest(int number) {
		int[] digitArr = digitArray(number);
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for (int i = 0; i < digitArr.length; i++) {
			if (digitArr[i] > largest) {
				secondLargest = largest;
				largest = digitArr[i];
			} else if (digitArr[i] > secondLargest && digitArr[i] != largest) {
				secondLargest = digitArr[i];
			}
		}
		return new int[]{largest, secondLargest};
	}
	
	// Method to find smallest and second smallest digits
	public static int[] smallestAndSecondSmallest(int number) {
		int[] digitArr = digitArray(number);
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		
		for (int i = 0; i < digitArr.length; i++) {
			if (digitArr[i] < smallest) {
				secondSmallest = smallest;
				smallest = digitArr[i];
			} else if (digitArr[i] < secondSmallest && digitArr[i] != smallest) {
				secondSmallest = digitArr[i];
			}
		}
		return new int[]{smallest, secondSmallest};
	}
	
	public static void main(String[] args) {
		
		// Taking user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = input.nextInt();
		
		// Method call
		int count = countDigits(number);
		int[] digitArr = digitArray(number);
		boolean duckNum = checkDuckNumber(number);
		boolean armstrongNum = checkArmstrongNumber(number);
		int[] largeArr = largestAndSecondLargest(number);
		int[] smallArr = smallestAndSecondSmallest(number);
		
		// Display results
		System.out.println("Number of digits in " + number + " : " + count);
		System.out.print("Array of digits: ");
		for (int i = count - 1; i >= 0; i--) {
			System.out.print(digitArr[i] + " ");
		}
		System.out.println();
		
		if (duckNum) {
			System.out.println("Number is a Duck number.");
		} else {
			System.out.println("Number is not a Duck number.");
		}
		
		if (armstrongNum) {
			System.out.println("Number is an armstrong number.");
		} else {
			System.out.println("Number is not an armstrong number.");
		}
		
		System.out.println("Largest digit is: " + largeArr[0] + " Second Largest digit is: " + largeArr[1]);
		
		System.out.println("Smallest digit is: " + smallArr[0] + " Second Smallest digit is: " + smallArr[1]);
	}
}