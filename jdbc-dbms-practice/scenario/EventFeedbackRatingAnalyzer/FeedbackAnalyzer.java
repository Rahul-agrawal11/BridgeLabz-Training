package scenario.EventFeedbackRatingAnalyzer;

import java.util.*;

class FeedbackAnalyzer {

    // Map<EventID, List<Integer>>
    private Map<String, List<Integer>> feedbackMap = new HashMap<>();

    // Add Rating
    public boolean addRating(String eventId, int rating) throws InvalidRatingException {

        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Invalid rating: " + rating + " (Allowed: 1 to 5)");
        }

        feedbackMap.putIfAbsent(eventId, new ArrayList<>());
        feedbackMap.get(eventId).add(rating);

        return true;
    }

    // Get average rating of an event
    public double getAverageRating(String eventId) {

        if (!feedbackMap.containsKey(eventId)) return 0.0;

        List<Integer> ratings = feedbackMap.get(eventId);

        int sum = 0;
        for (int r : ratings) sum += r;

        return (double) sum / ratings.size();
    }

    // Find top rated event(s)
    public List<String> getTopRatedEvents() {

        double bestAvg = 0.0;
        List<String> topEvents = new ArrayList<>();

        for (String eventId : feedbackMap.keySet()) {

            double avg = getAverageRating(eventId);

            if (avg > bestAvg) {
                bestAvg = avg;
                topEvents.clear();
                topEvents.add(eventId);

            } else if (avg == bestAvg) {
                topEvents.add(eventId);
            }
        }

        return topEvents;
    }

    // Print report
    public void printReport() {

        System.out.println("\n--- Event Ratings Report ---");

        for (String eventId : feedbackMap.keySet()) {
            System.out.println("Event: " + eventId +
                    " | Ratings: " + feedbackMap.get(eventId) +
                    " | Avg: " + getAverageRating(eventId));
        }

        System.out.println("Top Rated Event(s): " + getTopRatedEvents());
    }
}

