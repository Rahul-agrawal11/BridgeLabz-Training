import java.util.Scanner;

class ReverseNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		int orgNumber = number;
		int index = 0;
		while (number > 0) {
			int digit = number % 10;
			number /= 10;
			index++;
		}
		
		int[] digitArray = new int[index];
		for (int i = 0; i < index; i++) {
			digitArray[i] = orgNumber % 10;
			orgNumber /= 10;
		}
		for (int i = 0; i < index; i++) {
			System.out.print(digitArray[i]);
		}
	}
}