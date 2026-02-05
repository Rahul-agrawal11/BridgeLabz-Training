package streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Movie {
    String title;
    int rating;
    int year;

    public Movie(String title, int rating, int year) {
        this.title = title; 
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString() {
        return "[Movie Name: " + title + ", Rating: " + rating + ", Year: " + year + "]";
    }
}

public class TrendingMovies {

    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Dhurandhar", 5, 2026));
        movies.add(new Movie("Border 2", 5, 2026));
        movies.add(new Movie("The Fable", 4, 2024));
        movies.add(new Movie("Pathaan", 4, 2023));
        movies.add(new Movie("Tanhaji", 3, 2020));
        movies.add(new Movie("War", 5, 2019));

        movies.stream()
              .filter(movie -> movie.year >= 2018)
              .sorted(Comparator.comparingInt((Movie m) -> m.rating).reversed()
                      .thenComparingInt(m -> m.year).reversed())
              .limit(5)
              .forEach(System.out::println);
    }
}
