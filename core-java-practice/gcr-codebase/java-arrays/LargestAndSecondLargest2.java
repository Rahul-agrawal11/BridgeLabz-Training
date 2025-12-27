import java.util.Scanner;

class LargestAndSecondLargest2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long number = input.nextLong();

        int maxDigit = 10;
        long[] digits = new long[maxDigit];

        // Adding digits into array
        int index = 0;

        while (number > 0) {

            // If array is full, increase its size by 10
            if (index == maxDigit) {
                maxDigit += 10;

                long[] temp = new long[maxDigit];

                // Copy old array elements into temp
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp; // Assign expanded array
            }

            long remainder = number % 10;
            digits[index] = remainder;
            index++;

            number = number / 10;
        }

        long largest = Integer.MIN_VALUE;
        long secondLargest = Integer.MIN_VALUE;

        // Check for largest and second largest 
        for (int i = 0; i < index; i++) {
            long num = digits[i];

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } 
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Largest number: " + largest);
        System.out.println("Second Largest number: " + secondLargest);
    }
}
