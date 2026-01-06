import java.util.ArrayList;
import java.util.List;

// Interface
interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

// Abstract class
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;

    // Encapsulated sensitive data
    private List<String> medicalHistory = new ArrayList<>();

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Concrete method
    public String getPatientDetails() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age;
    }

    // Encapsulation: controlled access only
    public void addRecord(String diagnosis) {
        medicalHistory.add(diagnosis);
    }

    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }

    // Abstract method
    public abstract double calculateBill();
}

// In-Patient class
class InPatient extends Patient {

    private int daysAdmitted;
    private double dailyCharge;

    InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge + 2000; // room + service charges
    }
}

// Out-Patient class
class OutPatient extends Patient {

    private double consultationFee;

    OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }
}

// Main class
public class HospitalPatientManagement {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        patients.add(new InPatient(101, "Rahul", 21, 5, 3000));
        patients.add(new OutPatient(102, "Amit", 25, 800));

        for (Patient p : patients) {

            System.out.println(p.getPatientDetails());

            // Polymorphic call
            double bill = p.calculateBill();
            System.out.println("Total Bill: ₹" + bill);

            p.addRecord("General Checkup");
            p.viewRecords();

            System.out.println("--------------------------------");
        }
    }
}
