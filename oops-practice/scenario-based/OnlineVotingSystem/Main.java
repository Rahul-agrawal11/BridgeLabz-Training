package OnlineVotingSystem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Collections
        ArrayList<Candidate> candidates = new ArrayList<>();
        ArrayList<Voter> voters = new ArrayList<>();
        ArrayList<Vote> votes = new ArrayList<>();

        // Add candidates
        candidates.add(new Candidate(101, "Rahul"));
        candidates.add(new Candidate(102, "Amit"));

        // Add voters
        voters.add(new Voter(1, "Shivam", 19));
        voters.add(new Voter(2, "Rohit", 22));

        // Voting process
        try {
            // Shivam votes for Rahul
            Vote v1 = new Vote(candidates.get(0), voters.get(0));
            v1.castVote();
            votes.add(v1);

            // Rohit votes for Amit
            Vote v2 = new Vote(candidates.get(1), voters.get(1));
            v2.castVote();
            votes.add(v2);

            // Shivam tries to vote again (Duplicate vote)
            Vote v3 = new Vote(candidates.get(1), voters.get(0));
            v3.castVote();   // Exception will occur here

        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        // Declare results
        System.out.println("\n----- ELECTION RESULTS -----");
        for (Candidate c : candidates) {
            System.out.println(
                "Candidate: " + c.getName() +
                " | Votes: " + c.getVoteCount()
            );
        }
    }
}