import java.util.Scanner;

class InvoiceGeneratorForFreelancers {

    // Split by comma to get individual task details
    public static String[] splitParts(String detail) {
        String[] parts = detail.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim(); // remove leading/trailing spaces
        }
        return parts;
    }

    // Split each task detail into task name and amount
    public static String[][] splitTaskAndAmount(String detail) {
        String[] tasks = splitParts(detail);
        String[][] result = new String[tasks.length][2]; // [taskName, amount]

        for (int i = 0; i < tasks.length; i++) {
            String[] taskAndAmount = tasks[i].split("-");
            result[i][0] = taskAndAmount[0].trim(); // Task Name
            result[i][1] = taskAndAmount[1].trim(); // Amount
        }
        return result;
    }

    // Calculate total invoice amount
    public static double invoiceAmount(String detail) {
        String[][] tasks = splitTaskAndAmount(detail);
        double sum = 0;

        for (int i = 0; i < tasks.length; i++) {
            String amountStr = tasks[i][1];
            if (amountStr.contains(" INR")) {
                amountStr = amountStr.replace(" INR", "");
            }
            sum += Double.parseDouble(amountStr);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Detail: ");
        String detail = input.nextLine();

        double total = invoiceAmount(detail);
        System.out.println("Total Invoice Amount: " + total);
    }
}