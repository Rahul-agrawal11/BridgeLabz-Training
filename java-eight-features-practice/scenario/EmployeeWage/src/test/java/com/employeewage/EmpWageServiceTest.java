package com.employeewage;

import com.employeewage.repository.CompanyWageRepository;
import com.employeewage.service.EmpWageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpWageServiceTest {

    @Test
    void testCompanyAddedSuccessfully() {
        CompanyWageRepository repo = new CompanyWageRepository();
        EmpWageService service = new EmpWageService(repo);

        boolean added = service.addCompany("Amazon", 30, 20, 100);
        Assertions.assertTrue(added);
    }

    @Test
    void testInvalidCompanyNameRegex() {
        CompanyWageRepository repo = new CompanyWageRepository();
        EmpWageService service = new EmpWageService(repo);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addCompany("am", 30, 20, 100);
        });
    }

    @Test
    void testComputeWageDoesNotReturnNegative() {
        CompanyWageRepository repo = new CompanyWageRepository();
        EmpWageService service = new EmpWageService(repo);

        service.addCompany("Google", 25, 20, 100);
        service.computeWagesForAllCompanies();

        int total = service.getTotalWagesByCompany("Google");
        Assertions.assertTrue(total >= 0);
    }
}
