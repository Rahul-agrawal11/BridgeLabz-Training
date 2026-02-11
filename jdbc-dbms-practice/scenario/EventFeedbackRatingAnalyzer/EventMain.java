package scenario.EventFeedbackRatingAnalyzer;

public class EventMain {
	public static void main(String[] args) {

		FeedbackAnalyzer analyzer = new FeedbackAnalyzer();

		try {
			analyzer.addRating("EVENT-101", 5);
			analyzer.addRating("EVENT-101", 4);
			analyzer.addRating("EVENT-101", 5);

			analyzer.addRating("EVENT-102", 3);
			analyzer.addRating("EVENT-102", 4);

			analyzer.addRating("EVENT-103", 5);
			analyzer.addRating("EVENT-103", 5);

			analyzer.addRating("EVENT-104", 7); // invalid

		} catch (InvalidRatingException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		analyzer.printReport();

	}
}
