// The University is charging the student a fee of INR 125000 for the course. The University is willing to offer a discount of 10%. Write a program to find the discounted amount and discounted price the student will pay for the course.

class CalculateCourseFee {
    public static void main(String[] args) {
	    int fee = 125000;
		int discountPercent = 10;
		
		int discountedAmount = fee/100 * discountPercent;
		int discountedPrice = fee - discountedAmount;
		
		System.out.println("The discount amount is INR " + discountedAmount + " and final discounted fee is INR " + discountedPrice);
		
	}
}