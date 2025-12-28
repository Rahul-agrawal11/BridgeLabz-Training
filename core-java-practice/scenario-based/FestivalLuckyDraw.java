import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("\nEnter your lucky number (or -1 to exit): ");
            int number = input.nextInt();

            // Exit condition
            if (number == -1) {
                break;
            }

            // Invalid input check
            if (number <= 0) {
                System.out.println("Invalid number! Try again.");
                continue;
            }

            // Check divisibility by 3 and 5
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Congratulations! You won a gift!");
            } else {
                System.out.println("Sorry! Better luck next time.");
            }
        }

        System.out.println("\nLucky Draw ended. Happy Diwali!");
        input.close();
    }
}
