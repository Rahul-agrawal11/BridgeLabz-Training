package streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentDataStream {

    public static void main(String[] args) {

        String filePath = "students.dat";

        // Sample student data
        int roll = 101;
        String name = "Rahul";
        double gpa = 8.5;

        // ======= Writing data to file =======
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {

            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data stored successfully.");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

        // ======= Reading data from file =======
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {

            int readRoll = dis.readInt();
            String readName = dis.readUTF();
            double readGpa = dis.readDouble();

            System.out.println("Student Details:");
            System.out.println("Roll No: " + readRoll);
            System.out.println("Name: " + readName);
            System.out.println("GPA: " + readGpa);

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
