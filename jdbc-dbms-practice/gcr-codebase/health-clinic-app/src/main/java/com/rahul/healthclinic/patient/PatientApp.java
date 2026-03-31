package com.rahul.healthclinic.patient;

import java.sql.Date;

import com.rahul.healthclinic.helper.DuplicatePatientException;
import com.rahul.healthclinic.helper.PatientNotFoundException;

public class PatientApp {

    public static void main(String[] args) {

        PatientService service = new PatientService();

        try {
            // Register new patient
            Patient p1 = new Patient(
                    "Rahul Agrawal",
                    Date.valueOf("2002-06-15"),
                    "9876543210",
                    "rahul@gmail.com",
                    "Mathura",
                    "AB+"
            );

            int newId = service.registerNewPatient(p1);
            System.out.println("Patient registered successfully! ID = " + newId);

            // Fetch patient
            Patient fetched = service.getPatientById(newId);
            System.out.println("Patient Found: " + fetched);

        } catch (DuplicatePatientException e) {
            System.out.println("Duplicate Error: " + e.getMessage());

        } catch (PatientNotFoundException e) {
            System.out.println("Not Found: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
