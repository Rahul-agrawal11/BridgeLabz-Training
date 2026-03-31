package collections.InsurancePolicyManagementSystem2;

import java.time.LocalDate;
import java.util.*;

public class PolicyManagerMap {

    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(Policy p) {
        // HashMap & LinkedHashMap by policyNumber
        hashMap.put(p.getPolicyNumber(), p);
        linkedHashMap.put(p.getPolicyNumber(), p);

        // TreeMap by expiry date (date → list of policies)
        treeMap.putIfAbsent(p.getExpiryDate(), new ArrayList<>());
        treeMap.get(p.getExpiryDate()).add(p);
    }

    // Retrieve a policy by policy number
    public Policy getPolicy(String policyNumber) {
        return hashMap.get(policyNumber); // O(1)
    }

    // List all policies expiring within next 30 days
    public void policiesExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        treeMap.subMap(today, true, limit, true)
               .values()
               .forEach(list -> list.forEach(System.out::println));
    }

    // List all policies for a specific policyholder
    public void policiesByHolder(String holderName) {
        System.out.println("\nPolicies for Policyholder: " + holderName);
        hashMap.values().stream()
               .filter(p -> p.getPolicyHolderName().equalsIgnoreCase(holderName))
               .forEach(System.out::println);
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        // Remove from treeMap
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                // Remove policies from HashMap & LinkedHashMap
                for (Policy p : entry.getValue()) {
                    hashMap.remove(p.getPolicyNumber());
                    linkedHashMap.remove(p.getPolicyNumber());
                }
                iterator.remove();
            }
        }
    }

    // Display all policies in HashMap
    public void displayAllPolicies() {
        System.out.println("\nAll Policies (HashMap):");
        hashMap.values().forEach(System.out::println);
    }

    // Display all policies in LinkedHashMap (insertion order)
    public void displayLinkedHashMap() {
        System.out.println("\nAll Policies (LinkedHashMap - insertion order):");
        linkedHashMap.values().forEach(System.out::println);
    }

    // Display all policies sorted by expiry date (TreeMap)
    public void displayTreeMap() {
        System.out.println("\nAll Policies (TreeMap - sorted by expiry date):");
        treeMap.values().forEach(list -> list.forEach(System.out::println));
    }
}

