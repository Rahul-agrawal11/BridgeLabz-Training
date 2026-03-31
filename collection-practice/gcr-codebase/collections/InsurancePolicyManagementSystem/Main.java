package collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P101", "Rahul", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P102", "Sunny", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy("P103", "Amit", LocalDate.now().plusDays(20), "Health", 4500);
        Policy p4 = new Policy("P101", "Rahul Duplicate", LocalDate.now().plusDays(10), "Health", 5000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4); // duplicate (ignored by Set)

        manager.displayAllPolicies();
        manager.policiesExpiringSoon();
        manager.policiesByCoverage("Health");

        List<Policy> list = Arrays.asList(p1, p2, p3, p4);
        manager.findDuplicates(list);

        manager.performanceTest();
    }
}

