package csvHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {

	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\employee.csv";
		String name = "Rahul Agrawal";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = reader.readLine();
//			String line;
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(data[1].equalsIgnoreCase(name)) {
					System.out.println("Department\tSalary");
					System.out.println(data[2] + "\t\t" + data[3]);
					break;
				}
				
			}
		} catch(FileNotFoundException e) {
			
		}
	}

}
