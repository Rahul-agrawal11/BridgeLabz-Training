package scenario.MovieScheduleManager;

import java.util.Scanner;

public class CinemaTimeMain {

    /**
     * Validates whether the given time string is in valid HH:MM format.
     *
     * Rules:
     * - Time must contain exactly one colon (:)
     * - Hour must be between 0 and 23
     * - Minute must be between 0 and 59
     * - Only numeric values are allowed
     *
     */
    public static void checkTime(String time) throws InvalidTimeFormatException {
        try {
            String[] parts = time.split(":");

            // Ensure format contains exactly HH and MM
            if (parts.length != 2) {
                throw new InvalidTimeFormatException("Time must be in HH:MM format");
            }

            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            // Validate hour and minute range
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new InvalidTimeFormatException("Invalid hour or minute value");
            }

        } catch (NumberFormatException e) {
            // Handles non-numeric input like "AA:BB"
            throw new InvalidTimeFormatException("Time must contain only numbers");
        }
    }

    /**
     * Main method that provides a menu-driven interface
     * for managing movie titles and their show times.
     *
     * Features:
     * 1. Add movie with show time
     * 2. Search movie by title
     * 3. Display all movies
     * 4. Display printable movie list
     * 0. Exit application
     *
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Movie Title With ShowTime");
            System.out.println("2. Search Movie using Title");
            System.out.println("3. Display All Movies");
            System.out.println("4. Display Printable Movies");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // Clear input buffer

            try {
                switch (choice) {

                    case 1:
                        // Add a new movie with show time
                        System.out.print("Enter Movie Title: ");
                        String title = input.nextLine();

                        System.out.print("Enter Show Time (HH:MM): ");
                        String time = input.nextLine();

                        // Validate time before adding movie
                        checkTime(time);

                        if (MovieTitles.addMovie(title, time)) {
                            System.out.println("Movie added successfully!");
                        } else {
                            System.out.println("Duplicate movie title!");
                        }
                        break;

                    case 2:
                        // Search movie by title
                        System.out.print("Enter movie title to search: ");
                        String searchTitle = input.nextLine();

                        int index = MovieTitles.searchMovie(searchTitle);
                        if (index >= 0) {
                            System.out.println("Movie found at index: " + index);
                        } else {
                            System.out.println("Movie not found.");
                        }
                        break;

                    case 3:
                        // Display all movies with show times
                        MovieTitles.displayAllMovies();
                        break;

                    case 4:
                        // Display movies in printable format
                        MovieTitles.printable();
                        break;

                    case 0:
                        // Exit the application
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InvalidTimeFormatException e) {
                // Handles invalid time input
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        input.close();
    }
}
