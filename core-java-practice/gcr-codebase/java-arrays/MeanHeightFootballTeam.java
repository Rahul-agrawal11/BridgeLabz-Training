import java.util.Scanner;

class MeanHeightFootballTeam {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array to store heights of 11 players
        double[] heights = new double[11];

        double sum = 0.0;
        double mean;

        // Taking input for heights
        System.out.println("Enter the height of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = input.nextDouble();
        }

        // Calculating sum of heights
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Calculating mean height
        mean = sum / heights.length;

        // Displaying the mean height
        System.out.println("\nMean height of the football team: " + mean);

        input.close();
    }
}
