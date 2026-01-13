package OnlineVotingSystem;

public class Voter {
	 private int voterId;
	 private String name;
	 private int age;
	 private boolean voted;
	 
	 Voter(int voterId, String name, int age) {
		    if (age < 18) {
		        throw new IllegalArgumentException("Voter must be 18 or older.");
		    }
		    this.voterId = voterId;
		    this.name = name;
		    this.age = age;
		}

	 public int getId() {
		 return voterId;
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public boolean hasVoted() {
		 return voted;
	 }
	 
	 public void setVoted(boolean voted) {
	        this.voted = voted;
	 }
}
