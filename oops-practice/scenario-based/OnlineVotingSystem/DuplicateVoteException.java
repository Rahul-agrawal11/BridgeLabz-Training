package OnlineVotingSystem;

public class DuplicateVoteException extends Exception{
	DuplicateVoteException(String message) {
		super(message);
	}
}
