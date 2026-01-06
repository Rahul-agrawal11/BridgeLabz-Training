import java.util.Scanner;

class AWeekWorth {

    // Returns {hottestDay, coldestDay} (1-based indexing)
    public static int[] toFindHotCold(float[][] tempOfWeek) {
        float max = tempOfWeek[0][0];
        float min = tempOfWeek[0][0];
        int hottestDay = 1;
        int coldestDay = 1;

        for (int day = 0; day < 7; day++) {
            for (int hour = 0; hour < 24; hour++) {
                if (tempOfWeek[day][hour] > max) {
                    max = tempOfWeek[day][hour];
                    hottestDay = day + 1;
                }
                if (tempOfWeek[day][hour] < min) {
                    min = tempOfWeek[day][hour];
                    coldestDay = day + 1;
                }
            }
        }
        return new int[] { hottestDay, coldestDay };
    }

    // Returns average temperature per day
    public static float[] averageTemp(float[][] tempOfWeek) {
        float[] average = new float[7];

        for (int day = 0; day < 7; day++) {
            float sum = 0;
            for (int hour = 0; hour < 24; hour++) {
                sum += tempOfWeek[day][hour];
            }
            average[day] = sum / 24;
        }
        return average;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float[][] tempOfWeek = new float[7][24];

        for (int day = 0; day < 7; day++) {
            System.out.println("Enter temperatures for Day " + (day + 1) + ":");
            for (int hour = 0; hour < 24; hour++) {
                tempOfWeek[day][hour] = input.nextFloat();
            }
        }

        int[] result = toFindHotCold(tempOfWeek);
        System.out.println("Hottest Day: Day " + result[0]);
        System.out.println("Coldest Day: Day " + result[1]);

        float[] averages = averageTemp(tempOfWeek);
        for (int day = 0; day < averages.length; day++) {
            System.out.println("Average temperature of Day " + (day + 1) + ": " + averages[day]);
        }

        input.close();
    }
}