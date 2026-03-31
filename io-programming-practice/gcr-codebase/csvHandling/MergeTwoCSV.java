package csvHandling;

import java.io.*;
import java.util.HashMap;

public class MergeTwoCSV {

	public static void main(String[] args) {
		String filePath1 = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students1.csv";
		String filePath2 = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students2.csv";
		String mergedfilePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\merged-students.csv";
		try(BufferedReader reader1 = new BufferedReader(new FileReader(filePath1)); 
				BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
				BufferedWriter writer = new BufferedWriter(new FileWriter(mergedfilePath))) {
			HashMap<String, String> studentMap = new HashMap<>();
			reader1.readLine();
			String line;
			while((line  = reader1.readLine()) != null) {
				String[] data = line.split(",");
				studentMap.put(data[0], data[1] + "," + data[2]);
			}
			
			writer.write("ID,Name, Age, Marks, Grade");
			writer.newLine();
			
			reader2.readLine();
			while((line = reader2.readLine()) != null) {
				String[] data = line.split(",");
				String id = data[0];
				if(studentMap.containsKey(id)) {
					writer.write(id + "," + studentMap.get(id) + "," + data[1] + "," + data[2]);
					writer.newLine();
				}
			}
			System.out.println("CSV files merged successfully!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
