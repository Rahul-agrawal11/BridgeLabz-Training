import java.util.Scanner;

class CountFrequency {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Input number 
        System.out.print("Enter number: ");
        int number = input.nextInt();
		
		// Array to store frequency
		int[] freq = new int[10];
		
		while (number > 0) {
			int digit = number % 10;
			number /= 10;
			freq[digit]++; 
		}
		
		// Display frequency of numbers
		System.out.println("Number\tFrequency");
		for (int i = 0; i < 10; i++) {
			if (freq[i] > 0) {
				System.out.println((i) + "\t" + freq[i]);
			}
		}
	}
}