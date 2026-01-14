package stackAndQueue;

public class CircularTour {

	// Method to find starting point
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0;
        int balance = 0;
        int deficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - distance[i];

            if (balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        int start = findStartingPoint(petrol, distance);
        System.out.println("Starting Pump Index: " + start);
    }
}

