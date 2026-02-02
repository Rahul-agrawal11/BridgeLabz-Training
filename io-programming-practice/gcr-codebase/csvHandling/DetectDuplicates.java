package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DetectDuplicates {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students.csv";
		HashMap<String, String> students = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
			String line;
			System.out.println("ID\tName\tAge\tMarks");
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String id = data[0];
				if(students.containsKey(id)) {
					System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
				}
				if(!students.containsKey(id)) {
					students.put(data[0], data[1] + "," + data[2] + "," + data[3]);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
