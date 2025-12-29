import java.util.Scanner;

public class SandeepFitnessChallengeTracker {

	// Method to get Day Name 
    public static String toGetWeekDays(int dayNum) {
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday"};
        return weekDays[dayNum];
    }

    public static void main(String[] args) {

		// Taking user input
        Scanner input = new Scanner(System.in);

        int totalDays = 7;
        int[] weekCount = new int[totalDays];

        for (int i = 0; i < totalDays; i++) {

			// Method call
            String weekDay = toGetWeekDays(i);

            System.out.print("Enter for " + weekDay + " PushUp/Rest: ");
            String feedback = input.next();

			// Check for push up day or rest day
            if (feedback.equalsIgnoreCase("pushup")) {
                System.out.println("Enter " + weekDay + " PushUp count: ");
                weekCount[i] = input.nextInt();
            } else if (feedback.equalsIgnoreCase("rest")) {
                continue;
            }
        }

		// Count Total Push Ups in a week
        int totalPushups = 0;
        for (int count : weekCount) {
            totalPushups += count;
        }

		// Calculate Average Push Ups for a week
        double avgPushups = (double)totalPushups / (double)totalDays;

		// Display Results
        System.out.println("Total Pushups in one week: " + totalPushups);
        System.out.println("Average of all pushups: " + avgPushups);
    }
}
