// Create a program to check if a number is armstrong or not. Use the hints to show the steps clearly in the code

import java.util.Scanner;

class Armstrong {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three digit number: ");
        int number = input.nextInt();
        int originalNumber = number;
        int sum = 0;
        if (number > 99 && number < 1000) {
            while (originalNumber > 0) {
                int reminder = originalNumber % 10;
                originalNumber /= 10;
                sum = sum + (reminder * reminder * reminder);
            }
        } else {
            System.out.print("Please enter the three digit number.");
        }

        if (number == sum) {
            System.out.print(number + " is an armstrong number.");
        } else {
            System.out.print(number + " is not an armstrong number.");
        }
        input.close();
    }
}
