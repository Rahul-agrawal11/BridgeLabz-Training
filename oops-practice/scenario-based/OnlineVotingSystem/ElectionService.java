package OnlineVotingSystem;

public interface ElectionService {
	void registerVoter();
	
	void addCandidate();
	
	void castVote() throws DuplicateVoteException;
	
	void declareResult();
}
