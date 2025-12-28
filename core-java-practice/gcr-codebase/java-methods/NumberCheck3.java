import java.util.Scanner;

public class NumberCheck3 {
	
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
	
	// Method to calculate sum of square's of all digits
	public static int sumOfSquareOfDigits(int number) {
		int[] digitArr = digitArray(number);
		int sum = 0;
		
		for (int i = 0; i < digitArr.length; i++) {
			sum += Math.pow(digitArr[i], 2);
		}
		return sum;
	}
	
	// Method to check harshad number
	public static boolean checkHarshadNumber(int number) {
		int[] digitArr = digitArray(number);
		int sum = 0;
		
		for (int i = 0; i < digitArr.length; i++) {
			sum += digitArr[i];
		}
		
		if (number % sum != 0) {
			return false;
		}
		return true;
	}
	
	// Method to store unique numbers in an array
	public static int[] uniqueNumbers(int number) {
		int[] digitArr = digitArray(number);
		int uniqueCount = 0;
		int[] temp = new int[digitArr.length];

        for (int i = 0; i < digitArr.length; i++) {
            boolean isUnique = true;
            
            for (int j = 0; j < i; j++) {
                if (digitArr[i] == digitArr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = digitArr[i];
            }
        }
		
		int[] uniqueNum = new int[uniqueCount];
		for (int i = 0; i < uniqueCount; i++) {
			uniqueNum[i] = temp[i];
		}
		return uniqueNum;
	}
	
	// Method to count frequency of unique numbers
	public static int[][] countFrequency(int number) {
		int[] digitArr = digitArray(number);
		int[] uniqueNum = uniqueNumbers(number);
		
		int[] temp = new int[10];
		
		for (int i = 0; i < digitArr.length; i++) {
			temp[digitArr[i]]++;
		}
		
		int[][] uniqueNumFreq = new int[uniqueNum.length][2];
		
		for (int i = 0; i < uniqueNum.length; i++) {
			uniqueNumFreq[i][0] = uniqueNum[i];
			uniqueNumFreq[i][1] = temp[uniqueNum[i]];
		}
		return uniqueNumFreq;
	}
	
	public static void main(String[] args) {
		
		// Taking user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = input.nextInt();
		
		// Method call
		int count = countDigits(number);
		int[] digitArr = digitArray(number);
		int sumOfSqDigit = sumOfSquareOfDigits(number);
		boolean harshadNum = checkHarshadNumber(number);
		int[][] uniqueNumFreq = countFrequency(number);
		
		// Display results
		System.out.println("Number of digits: " + count);
		
		System.out.print("Array of digits: ");
		for (int i = count - 1; i >= 0; i--) {
			System.out.print(digitArr[i] + " ");
		}
		System.out.println();
		
		System.out.println("Sum of square of digits: " + sumOfSqDigit);
		
		if (harshadNum) {
			System.out.println("Number is a harshad number.");
		} else {
			System.out.println("Number is not a harshad number.");
		}
		
		System.out.println("Number\tFrequency");
		for (int i = 0; i < uniqueNumFreq.length; i++) {
			System.out.println(uniqueNumFreq[i][0] + "\t" + uniqueNumFreq[i][1]);
		}
	}
}