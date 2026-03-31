package streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Doctor {
	String name;
	String speciality;
	boolean availableOnWeekend;
	public Doctor(String name, String speciality, boolean availableOnWeekend) {
		this.name = name;
		this.speciality = speciality;
		this.availableOnWeekend = availableOnWeekend;
	}
	public String getSpeciality() {
		return speciality;
	}
	
	public boolean isAvailableOnWeekend() {
		return availableOnWeekend;
	}
	
	@Override
	public String toString() {
		return name + " - " + speciality;
	}
}

public class HospitalDoctorAvailability {

	public static void main(String[] args) {
		
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(new Doctor("Rahul", "Cardiology", true));
		doctors.add(new Doctor("Amit", "Orthopedic", false));
		doctors.add(new Doctor("Neha", "Neurology", false));
		doctors.add(new Doctor("Priya", "Dermatology", true));
		
		List<Doctor> weekendDoctors = doctors.stream().filter(Doctor::isAvailableOnWeekend)
				.sorted(Comparator.comparing(Doctor::getSpeciality))
				.collect(Collectors.toList());
		weekendDoctors.forEach(System.out::println);
	}

}
