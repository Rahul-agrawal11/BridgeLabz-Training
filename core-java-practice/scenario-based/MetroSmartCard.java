import java.util.Scanner;

public class MetroSmartCard {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial smart card balance: ");
        double balance = input.nextDouble();

        while (balance > 0) {

            System.out.print("\nEnter distance travelled (or -1 to quit): ");
            int distance = input.nextInt();

            // Exit condition
            if (distance == -1) {
                break;
            }

            // Fare calculation using ternary operator
            int fare = (distance <= 5) ? 10 :
                       (distance <= 15) ? 20 : 30;

            // Check balance
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted: ₹" + fare);
                System.out.println("Remaining balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("\nSmart Card session ended.");
        System.out.println("Final balance: ₹" + balance);

        input.close();
    }
}
