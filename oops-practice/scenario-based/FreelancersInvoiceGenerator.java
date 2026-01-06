class InvalidInvoiceFormatException extends Exception {
    InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

class InvoiceGenerator {

    // Parses invoice input and returns task array
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input is empty");
        }

        String[] tasks = input.split(",");

        for (String task : tasks) {
            if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException(
                    "Invalid format. Missing '-' in: " + task
                );
            }

            String[] parts = task.split("-");

            if (parts.length != 2) {
                throw new InvalidInvoiceFormatException(
                    "Invalid task format: " + task
                );
            }

            String amountPart = parts[1].trim();

            // Extract numeric amount
            String amount = amountPart.replaceAll("[^0-9]", "");

            if (amount.isEmpty()) {
                throw new InvalidInvoiceFormatException(
                    "Amount missing in: " + task
                );
            }
        }
        return tasks;
    }

    // Calculates total amount from tasks
    public static int getTotalAmount(String[] tasks) {

        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");
            String amountPart = parts[1].trim();
            int amount = Integer.parseInt(
                amountPart.replaceAll("[^0-9]", "")
            );
            total += amount;
        }
        return total;
    }
}

public class FreelancersInvoiceGenerator {
    public static void main(String[] args) {

        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        try {
            String[] tasks = InvoiceGenerator.parseInvoice(input);
            int total = InvoiceGenerator.getTotalAmount(tasks);

            System.out.println("Invoice Details:");
            for (String task : tasks) {
                System.out.println(task.trim());
            }

            System.out.println("Total Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}