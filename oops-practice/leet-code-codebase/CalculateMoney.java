/* 1716 Leetcode problem */
import java.util.Scanner;

class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int weekStart = 1;

        while (n > 0) {
            for (int day = 0; day < 7 && n > 0; day++) {
                total += weekStart + day;
                n--;
            }
            weekStart++;
        }

        return total;
    }
}

public class CalculateMoney {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = input.nextInt();
		
		Solution sn = new Solution();
		int total = sn.totalMoney(num);
		
		System.out.println("Money in Leetcode bank: " + total);
	}
}