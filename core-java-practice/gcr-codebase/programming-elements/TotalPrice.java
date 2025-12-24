// Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.

import java.util.Scanner;

class TotalPrice {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the unit price: ");
		float unitPrice = input.nextFloat();
		
		System.out.print("Enter the quantity: ");
		float quantity = input.nextFloat();
		
		float totalPurchase = unitPrice * quantity;
		
		System.out.println("The total purchase price is INR " + totalPurchase + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
		input.close();
	}
}