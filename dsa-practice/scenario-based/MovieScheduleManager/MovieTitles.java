package scenario.MovieScheduleManager;

import java.util.ArrayList;
import java.util.List;

public class MovieTitles {

    // Data storage
    private static List<String> movieTitles = new ArrayList<>();
    private static List<String> showTimes = new ArrayList<>();

    // Add movie if title is not duplicate
    public static boolean addMovie(String title, String time) {
        if (movieTitles.contains(title.toLowerCase())) {
            return false;
        }
        movieTitles.add(title.toLowerCase());
        showTimes.add(time);
        return true;
    }

    // Search movie by title
    public static int searchMovie(String title) {
        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    // Display movies normally
    public static void displayAllMovies() {
        System.out.println("============== Cinema Time ==============");
        if (movieTitles.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
        	String result = String.format("Movie Title: %s Show Time: %s", movieTitles.get(i), showTimes.get(i));
            System.out.println(result);
        }
        System.out.println("=========================================");
    }

    // Printable version (array conversion demo)
    public static void printable() {
        String[] titles = movieTitles.toArray(new String[0]);
        String[] times = showTimes.toArray(new String[0]);

        System.out.println("========== Printable Cinema Time =========");
        for (int i = 0; i < titles.length; i++) {
            System.out.println("Movie: " + titles[i] + " | Time: " + times[i]);
        }
        System.out.println("==========================================");
    }
}
