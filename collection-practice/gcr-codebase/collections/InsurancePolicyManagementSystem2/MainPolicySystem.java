package collections.InsurancePolicyManagementSystem2;

import java.time.LocalDate;

public class MainPolicySystem {
    public static void main(String[] args) {

        PolicyManagerMap manager = new PolicyManagerMap();

        Policy p1 = new Policy("P101", "Ram", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P102", "Shyam", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy("P103", "Amit", LocalDate.now().plusDays(20), "Home", 4500);
        Policy p4 = new Policy("P104", "Ram", LocalDate.now().minusDays(5), "Health", 4000); // expired

        // Add policies
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        // Retrieve policy by number
        System.out.println("Retrieve Policy P102:");
        System.out.println(manager.getPolicy("P102"));

        // Policies expiring soon
        manager.policiesExpiringSoon();

        // Policies by policyholder
        manager.policiesByHolder("Alice");

        // Remove expired policies
        manager.removeExpiredPolicies();

        // Display all maps
        manager.displayAllPolicies();
        manager.displayLinkedHashMap();
        manager.displayTreeMap();
    }
}

