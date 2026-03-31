import java.util.ArrayList;
import java.util.Iterator;

/* ---------- Abstraction ---------- */
interface IPayable {
    double calculateBill();
}

/* ---------- Base Class ---------- */
class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String displayInfo() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age;
    }
}

/* ---------- Inheritance + Polymorphism ---------- */
class InPatient extends Patient implements IPayable {
    private int daysAdmitted;
    private double dailyCharge;

    InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge + 2000;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
               ", Type: InPatient" +
               ", Days: " + daysAdmitted +
               ", Bill: " + calculateBill();
    }
}

class OutPatient extends Patient implements IPayable {
    private double consultationFee;

    OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
               ", Type: OutPatient" +
               ", Bill: " + calculateBill();
    }
}

/* ---------- Doctor Class ---------- */
class Doctor {
    private int doctorId;
    private String name;
    private int fee;

    Doctor(int doctorId, String name, int fee) {
        this.doctorId = doctorId;
        this.name = name;
        this.fee = fee;
    }

    public String displayInfo() {
        return "Doctor ID: " + doctorId +
               ", Name: " + name +
               ", Fee: " + fee;
    }
}

/* ---------- Hospital Management (CRUD) ---------- */
class HospitalPatientManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();

    // CREATE
    public static void addPatient(Patient p) {
        patients.add(p);
    }

    // READ
    public static void displayPatients() {
        for (Patient p : patients) {
            System.out.println(p.displayInfo()); // Polymorphism
        }
    }

    // UPDATE
    public static void updatePatientName(int id, String newName) {
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                p.setName(newName);
            }
        }
    }

    // DELETE
    public static void deletePatient(int id) {
        Iterator<Patient> itr = patients.iterator();
        while (itr.hasNext()) {
            if (itr.next().getPatientId() == id) {
                itr.remove();
            }
        }
    }

    public static void main(String[] args) {

        Patient p1 = new InPatient(1, "Rahul", 25, 5, 1500);
        Patient p2 = new OutPatient(2, "Amit", 30, 800);

        addPatient(p1);
        addPatient(p2);

        System.out.println("---- All Patients ----");
        displayPatients();

        updatePatientName(1, "Rahul Sharma");

        System.out.println("---- After Update ----");
        displayPatients();

        deletePatient(2);

        System.out.println("---- After Deletion ----");
        displayPatients();
    }
}