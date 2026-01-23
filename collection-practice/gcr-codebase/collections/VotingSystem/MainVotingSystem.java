package collections.VotingSystem;

public class MainVotingSystem {
    public static void main(String[] args) {

        VotingSystem voting = new VotingSystem();

        // Voting
        voting.vote("Rahul");
        voting.vote("Sagar");
        voting.vote("Rahul");
        voting.vote("Vishnu");
        voting.vote("Sagar");
        voting.vote("Rahul");

        // Display votes
        voting.displayVotesHashMap();   // Unordered
        voting.displayVotesLinked();    // Insertion order
        voting.displayVotesSorted();    // Sorted by name

        // Individual vote count
        System.out.println("\nVotes for Rahul: " + voting.getVotes("Rahul"));
        System.out.println("Votes for Sagar: " + voting.getVotes("Sagar"));

        // Winner
        System.out.println("\nWinner: " + voting.findWinner());
    }
}

