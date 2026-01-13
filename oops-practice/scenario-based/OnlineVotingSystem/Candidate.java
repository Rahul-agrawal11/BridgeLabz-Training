package OnlineVotingSystem;

public class Candidate {
	private int canId;
	private String name;
	private int voteCount;
	
	Candidate(int canId, String name) {
		this.canId = canId;
		this.name = name;
		this.voteCount = 0;
	}
	
	public int getId() {
		return canId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getVoteCount() {
        return voteCount;
    }

    public void incrementVoteCount() {
        voteCount++;
    }
}
