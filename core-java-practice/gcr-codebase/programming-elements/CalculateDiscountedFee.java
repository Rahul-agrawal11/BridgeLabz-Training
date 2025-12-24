// Write a new program similar to the program # 6 but take user input for Student Fee and University Discount

import java.util.Scanner;

class CalculateDiscountedFee {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter Total Course Fee: ");
	    double fee = input.nextDouble();
		
		System.out.print("Enter Discount Percent: ");
		double discountPercent = input.nextDouble();
		
		double discountedAmount = fee / 100 * discountPercent;
		double discountedPrice = fee - discountedAmount;
		
		System.out.println("The discount amount is INR " + discountedAmount + " and final discounted fee is INR " + discountedPrice);
		input.close();
	}
}