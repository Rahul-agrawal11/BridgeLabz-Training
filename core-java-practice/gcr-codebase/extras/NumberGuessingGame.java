import java.util.Scanner;

class NumberGuessingGame {

    // Generates a random number between min and max 
    public static int generateGuess(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // Updates the range based on user feedback and returns new guess
    public static int nextGuess(String feedback, int currentGuess, int min, int max) {

        if (feedback.equalsIgnoreCase("high")) {
            max = currentGuess - 1;   // Guess was too high
        } 
        else if (feedback.equalsIgnoreCase("low")) {
            min = currentGuess + 1;   // Guess was too low
        }

        return generateGuess(min, max);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int min = 1;
        int max = 100;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        int computerGuess = generateGuess(min, max);

        while (true) {

            System.out.println("Computer guessed: " + computerGuess);
            System.out.print("Enter feedback (high / low / correct): ");
            String feedback = input.next();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed the correct number!");
                break;
            }

            // Update range based on feedback
            if (feedback.equalsIgnoreCase("high")) {
                max = computerGuess - 1;
            } 
            else if (feedback.equalsIgnoreCase("low")) {
                min = computerGuess + 1;
            }

            // Generate next guess
            computerGuess = nextGuess(feedback, computerGuess, min, max);
        }

        input.close();
    }
}
