import java.util.Scanner;
class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number I: ");
        int number1 = input.nextInt();
        System.out.print("Enter number II: ");
        int number2 = input.nextInt();

        int result = number1 + number2;

        System.out.println("Result: " + result);
    }
}