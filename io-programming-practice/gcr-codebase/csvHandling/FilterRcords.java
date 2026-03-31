package csvHandling;

import java.io.*;

public class FilterRcords {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students.csv";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = reader.readLine();
			System.out.println("ID\tName\tAge\tMarks");
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if(Integer.parseInt(data[3]) > 80) {
					System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
