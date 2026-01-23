package collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;

public class Policy implements Comparable<Policy> {

    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getCoverageType() { return coverageType; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy p = (Policy) obj;
        return policyNumber.equals(p.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate); // TreeSet sorting by expiry date
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

