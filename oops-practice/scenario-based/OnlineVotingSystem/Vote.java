package OnlineVotingSystem;

public class Vote implements ElectionService {

    private static int counter = 1;

    private int voteId;
    private Candidate candidate;
    private Voter voter;

    public Vote(Candidate candidate, Voter voter) {
        this.voteId = counter++;
        this.candidate = candidate;
        this.voter = voter;
    }

    public int getVoteId() {
        return voteId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Voter getVoter() {
        return voter;
    }

    @Override
    public void registerVoter() {
        System.out.println("Voter Registered Successfully.");
    }

    @Override
    public void addCandidate() {
        System.out.println("Candidate Added Successfully.");
    }

    @Override
    public void castVote() throws DuplicateVoteException {

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already cast a vote!");
        }

        voter.setVoted(true);
        candidate.incrementVoteCount();   
        System.out.println(
            "Vote cast successfully for candidate: " + candidate.getName()
        );
    }

    @Override
    public void declareResult() {
        System.out.println("Vote ID: " + voteId);
        System.out.println("Voter: " + voter.getName());
        System.out.println("Voted Candidate: " + candidate.getName());
    }
}
