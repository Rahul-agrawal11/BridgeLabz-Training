package csvHandling;

import java.io.*;

public class WriteCSV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\employee.csv";
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write("ID,Name,Department,Salary\n");
			writer.write("101,Rahul,IT,56000\n");
            writer.write("102,Amit,IT,45000\n");
            writer.write("103,Vishnu,Tech,44000\n");
            writer.write("104,Himanshu,WebDev,48000\n");
            writer.write("105,Ronnie,IT,46000\n");
            writer.write("106,Sagar,Adv,60000\n");
            System.out.println("CSV file written successfully!");

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
