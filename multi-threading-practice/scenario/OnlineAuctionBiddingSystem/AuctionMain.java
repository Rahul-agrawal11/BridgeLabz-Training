package scenario.OnlineAuctionBiddingSystem;

public class AuctionMain {
	public static void main(String[] args) {

		AuctionItem item = new AuctionItem(1, "iPhone 15 Pro");

		User u1 = new User(101, "Rahul");
		User u2 = new User(102, "Amit");
		User u3 = new User(103, "Neha");

		try {
			item.placeBid(new Bid(u1, 50000));
			item.placeBid(new Bid(u2, 52000));
			item.placeBid(new Bid(u3, 51000)); // invalid

		} catch (InvalidBidException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		try {
			item.placeBid(new Bid(u3, 55000));
		} catch (InvalidBidException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		item.displayAllBids();
	}
}
