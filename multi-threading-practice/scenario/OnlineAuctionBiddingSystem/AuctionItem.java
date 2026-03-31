package scenario.OnlineAuctionBiddingSystem;

import java.util.*;

class AuctionItem {

    private int itemId;
    private String itemName;

    // TreeMap<User, BidAmount>
    private TreeMap<User, Double> bids = new TreeMap<>();

    public AuctionItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    // Place bid
    public boolean placeBid(Bid bid) throws InvalidBidException {

        double currentHighest = getHighestBidAmount();

        if (bid.getAmount() <= currentHighest) {
            throw new InvalidBidException(
                    "Bid rejected! Your bid: " + bid.getAmount() +
                            " must be higher than current highest: " + currentHighest
            );
        }

        bids.put(bid.getUser(), bid.getAmount());
        return true;
    }

    // Get highest bid amount
    public double getHighestBidAmount() {

        double max = 0.0;

        for (double amt : bids.values()) {
            if (amt > max) {
                max = amt;
            }
        }

        return max;
    }

    // Get highest bidder
    public User getHighestBidder() {

        User highestUser = null;
        double highestBid = 0.0;

        for (Map.Entry<User, Double> entry : bids.entrySet()) {
            if (entry.getValue() > highestBid) {
                highestBid = entry.getValue();
                highestUser = entry.getKey();
            }
        }

        return highestUser;
    }

    public void displayAllBids() {

        System.out.println("\n--- All Bids for Item: " + itemName + " ---");

        if (bids.isEmpty()) {
            System.out.println("No bids placed yet.");
            return;
        }

        for (Map.Entry<User, Double> entry : bids.entrySet()) {
            System.out.println(entry.getKey().getName() + " -> " + entry.getValue());
        }

        System.out.println("Highest Bid: " + getHighestBidAmount() +
                " by " + getHighestBidder().getName());
    }
}