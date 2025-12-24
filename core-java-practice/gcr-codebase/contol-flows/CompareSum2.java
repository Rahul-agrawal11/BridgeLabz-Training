/* Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 
and show the result from both computations was correct. */

import java.util.Scanner;

class CompareSum2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.print("Enter the value: ");
        int number = input.nextInt();
        double sum1 = 0, sum2 = 0;
        if (number >= 0) {
            for (int num = number; num >= 0; num--) {
				sum1 += num;
			}
            sum2 = number * ((number + 1) / 2.0);

        } else {
            System.out.println("The number is not a natural number.");
        }

        if (sum1 == sum2) {
            System.out.println("The result from both approach is: " + sum1);
        }
        input.close();
    }
}
