package collectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
	String genre;
	int totalPages;
	public Book(String genre, int totalPages) {
		this.genre = genre;
		this.totalPages = totalPages;
	}
	public String getGenre() {
		return genre;
	}
	public int getTotalPages() {
		return totalPages;
	}
}

public class LibraryBookStatistics {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(new Book("Java Programming", 1120),
				new Book("Algorithms & Data Structures", 1300),
				new Book("Computer Architecture", 800),
				new Book("Operating Systems", 1000),
				new Book("Java Programming", 1200),
				new Book("Operating Systems", 500));
		
		Map<String, IntSummaryStatistics> statesByGenre = books.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getTotalPages)));
		
		statesByGenre.forEach((genre,stats) -> 
		{
			System.out.println("Genre: " + genre);
			System.out.println("Total pages: " + stats.getSum());
			System.out.println("Average: " + stats.getAverage());
			System.out.println("Maximum Pages: " + stats.getMax());
			System.out.println("---------------------------------\n");
		});

	}

}
