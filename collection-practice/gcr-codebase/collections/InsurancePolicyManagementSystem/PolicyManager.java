package collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    // 1️⃣ All unique policies
    public void displayAllPolicies() {
        System.out.println("All Policies:");
        hashSet.forEach(System.out::println);
    }

    // 2️⃣ Policies expiring within 30 days
    public void policiesExpiringSoon() {
        System.out.println("\nPolicies Expiring Soon (30 days):");
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Policy p : hashSet) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                System.out.println(p);
            }
        }
    }

    // 3️⃣ Policies by coverage type
    public void policiesByCoverage(String type) {
        System.out.println("\nPolicies with coverage type: " + type);
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // 4️⃣ Find duplicate policies by policy number
    public void findDuplicates(List<Policy> list) {
        System.out.println("\nDuplicate Policies:");
        Set<String> seen = new HashSet<>();
        for (Policy p : list) {
            if (!seen.add(p.getPolicyNumber())) {
                System.out.println(p);
            }
        }
    }

    // 5️⃣ Performance Comparison
    public void performanceTest() {
        int n = 100000;
        List<Policy> policies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            policies.add(new Policy("P" + i, "User" + i,
                    LocalDate.now().plusDays(i % 365),
                    "Health", i * 10));
        }

        testSetPerformance("HashSet", new HashSet<>(), policies);
        testSetPerformance("LinkedHashSet", new LinkedHashSet<>(), policies);
        testSetPerformance("TreeSet", new TreeSet<>(), policies);
    }

    private void testSetPerformance(String name, Set<Policy> set, List<Policy> policies) {
        long start, end;

        start = System.nanoTime();
        set.addAll(policies);
        end = System.nanoTime();
        System.out.println(name + " Add Time: " + (end - start));

        Policy search = policies.get(policies.size() / 2);
        start = System.nanoTime();
        set.contains(search);
        end = System.nanoTime();
        System.out.println(name + " Search Time: " + (end - start));

        start = System.nanoTime();
        set.remove(search);
        end = System.nanoTime();
        System.out.println(name + " Remove Time: " + (end - start));
        System.out.println("---------------------------------");
    }
}
