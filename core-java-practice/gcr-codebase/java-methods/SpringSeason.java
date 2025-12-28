public class SpringSeason {

    // Method to check if the date is in Spring Season
    public static boolean isSpringSeason(int month, int day) {

        if ((month == 3 && day >= 20) ||
            (month == 4) ||
            (month == 5) ||
            (month == 6 && day <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        // Reading command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Method call
        boolean result = isSpringSeason(month, day);

        // Output
        if (result) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
