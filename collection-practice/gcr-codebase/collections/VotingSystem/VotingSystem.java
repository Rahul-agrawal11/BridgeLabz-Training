package collections.VotingSystem;

import java.util.*;

public class VotingSystem {

    // HashMap: fast vote updates
    private Map<String, Integer> voteMap = new HashMap<>();

    // LinkedHashMap: maintain insertion order
    private Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();

    // TreeMap: sorted order by candidate name
    private Map<String, Integer> treeVoteMap = new TreeMap<>();

    // Add vote to a candidate
    public void vote(String candidate) {
        // Update HashMap
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // Update LinkedHashMap (maintains insertion order)
        linkedVoteMap.put(candidate, linkedVoteMap.getOrDefault(candidate, 0) + 1);

        // Update TreeMap (sorted by candidate name)
        treeVoteMap.put(candidate, treeVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Get vote count for a candidate
    public int getVotes(String candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }

    // Display votes in insertion order
    public void displayVotesLinked() {
        System.out.println("\nVotes (Insertion Order - LinkedHashMap):");
        linkedVoteMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // Display votes sorted by candidate name
    public void displayVotesSorted() {
        System.out.println("\nVotes (Sorted Order - TreeMap):");
        treeVoteMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // Display votes in HashMap (unordered)
    public void displayVotesHashMap() {
        System.out.println("\nVotes (HashMap - Unordered):");
        voteMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // Find candidate with maximum votes
    public String findWinner() {
        return voteMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No votes yet");
    }
}

