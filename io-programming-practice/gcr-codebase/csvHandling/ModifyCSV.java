package csvHandling;

import java.io.*;

public class ModifyCSV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\employee.csv";
		String filePath2 = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\employee2.csv";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath)); 
				BufferedWriter writer = new BufferedWriter(new FileWriter(filePath2))) {
			String line = reader.readLine();
			writer.write(line + "\n");
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(data[2].equals("IT")) {
					double salary = Integer.parseInt(data[3]);
					salary += (salary * 0.1);
					String combined = data[0] + "," + data[1] + "," + data[2] + "," + salary + "\n";
					writer.write(combined);
					System.out.println("Successfully!");
				}
			}
		} catch(Exception e) {
			
		}
	}

}
