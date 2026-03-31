/* The Coffee Counter Chronicles ☕
Ravi runs a café. Each customer orders different coffee types with quantities. Write a program
that:
● Asks for coffee type (switch)
● Calculates total bill (price * quantity)
● Adds GST using arithmetic operators
Use while to continue for the next customer and break when "exit" is typed. */

import java.util.Scanner;

class CoffeeCounterChronicles {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double GST = 0.05;

        while (true) {
            System.out.println("Enter coffe name(espresso/latte/cappuccino): ");
            String coffeeType = input.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Cafe Closed. Thank you!");
                break;
            }

            double onePrice = 0;

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    onePrice = 120;
                    break;
                case "latte":
                    onePrice = 150;
                    break;
                case "cappuccino":
                    onePrice = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type.");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
            input.nextLine();

            double price = onePrice * quantity;
            double gstAmount = price * GST;
            double totalBill = price + gstAmount;

            System.out.println("\n--- Bill Details ---");
            System.out.println("Coffee Type : " + coffeeType);
            System.out.println("Price of One: " + onePrice);
            System.out.println("Quantity    : " + quantity);
            System.out.println("GST Amount  : " + gstAmount);
            System.out.println("Final Bill  : " + totalBill);
        }
    }
}
