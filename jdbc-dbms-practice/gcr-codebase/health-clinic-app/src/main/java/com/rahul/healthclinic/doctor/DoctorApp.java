package com.rahul.healthclinic.doctor;

import java.util.List;

import com.rahul.healthclinic.helper.DoctorNotAvailableException;

public class DoctorApp {

    public static void main(String[] args) {

        DoctorService service = new DoctorService();

        try {
            // Add doctor
            Doctor d1 = new Doctor(
                    "Amit",
                    "Sharma",
                    "9998887776",
                    "amit@gmail.com",
                    1,          // specialty_id
                    500.00      // fee
            );

            int doctorId = service.addDoctor(d1);
            System.out.println("Doctor Added Successfully! ID = " + doctorId);

            // View doctor by ID
            Doctor doctor = service.getDoctorById(doctorId);
            System.out.println("Doctor Found: " + doctor);

            // View doctors by specialty
            List<Doctor> doctors = service.viewDoctorsBySpecialty(1);
            System.out.println("Doctors in Specialty 1:");
            for (Doctor d : doctors) {
                System.out.println(d);
            }

            // Deactivate doctor
            boolean deactivated = service.deactivateDoctor(doctorId);
            System.out.println("Doctor Deactivated: " + deactivated);

        } catch (DoctorNotAvailableException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
