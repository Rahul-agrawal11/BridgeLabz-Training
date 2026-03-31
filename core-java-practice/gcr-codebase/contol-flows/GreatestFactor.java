// Create a program to print the greatest factor of a number beside itself using a loop.

import java.util.Scanner;

class GreatestFactor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = input.nextInt();
        int greatestFactor = 1;
        if (number > 0) {
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    if (i > greatestFactor) {
                        greatestFactor = i;
                    }
                }
            }
        } else {
            System.out.println("Please enter a positive number.");
        }

        System.out.println("The greatest factor of the " + number + " is: " + greatestFactor);
        input.close();
    }
}
